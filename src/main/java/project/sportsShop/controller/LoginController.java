package project.sportsShop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import project.sportsShop.service.UserService;
import project.sportsShop.vo.User;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String login(Model model, @RequestParam(required = false, defaultValue = "0") int code) {
        model.addAttribute("code", code);
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model, @RequestParam(required = false, defaultValue = "0") int error) {
        model.addAttribute("error", error);
        return "register";
    }

    @PostMapping("/register")
    public String doRegister(@RequestParam String username,
                             @RequestParam String password, @RequestParam String verifyPassword) {

        if (!password.equals(verifyPassword)) {
            return "redirect:/register?error=1";
        }

        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));

        int code = userService.addUser(user);
        if (code != 0) {
            return "redirect:/register?error=" + code;
        }

        return "redirect:/login?code=1";
    }
}
