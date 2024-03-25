package develhope.co.Exercise17;

import io.micrometer.common.lang.Nullable;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class MonthInterceptor implements HandlerInterceptor {
    private final List<Month> listedMonthsInInterceptor = addMonthsInList();

    private List<Month> addMonthsInList() {
        List<Month> fullListMonths = new ArrayList<>();
        fullListMonths.add(new Month(1, "Jan", "Gen", "Boh"));
        fullListMonths.add(new Month(2, "Feb", "Feb", "Boh"));
        fullListMonths.add(new Month(3, "Mar", "Mar", "Boh"));
        fullListMonths.add(new Month(4, "Apr", "Apr", "Boh"));
        fullListMonths.add(new Month(5, "May", "Mag", "Boh"));
        fullListMonths.add(new Month(6, "Jun", "Giu", "Boh"));
        return fullListMonths;
    }

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String monthNumberString = request.getHeader("monthNumber");

        if (monthNumberString == null || monthNumberString.isEmpty()) {
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            return false;
        }
        int monthNumber = Integer.parseInt(monthNumberString);

        Optional<Month> monthFounded = listedMonthsInInterceptor.stream()
                .filter(month -> month.getMonthNumber() == monthNumber).findFirst();

        if(monthFounded.isPresent()){
            request.setAttribute("month", monthFounded.get());
        }else{
            Month emptyMonth = new Month(0, "nope", "nope", "nope");
            request.setAttribute("month", emptyMonth);
        }
        response.setStatus(HttpStatus.OK.value());
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
    }

}
