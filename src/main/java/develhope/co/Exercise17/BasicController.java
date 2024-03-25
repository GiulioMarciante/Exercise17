package develhope.co.Exercise17;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/welcome")
public class BasicController {
    @GetMapping("")
    public String welcomeUser(){
        return "Welcome user";
    }
}
