package com.dev.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @RequestMapping("/login")
    public String login (Model model) {
        System.out.println("login has been invoked!");
        return "tmpl_login";
    }
}
