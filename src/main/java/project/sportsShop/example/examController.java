package project.sportsShop.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class examController {
    @GetMapping("/hi")
    public String hello(Model model){
        model.addAttribute("data", "hello!");
        return "hi";
    }

}