package com.dev.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @RequestMapping("/login-page")
    public String loginPage (Model model) {
        return "tmpl_login";
    }

    @RequestMapping("/login")
    public String login (String userName, String password) {
        return "tmpl_login";
    }

}
