package develhope.co.Exercise17;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/months")
public class MonthController {
    @GetMapping("")
    public Month getMonthByNumber(HttpServletRequest request){
        Month month = (Month) request.getAttribute("month");
        return month;
    }
}
