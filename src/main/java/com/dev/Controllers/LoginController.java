package com.dev.Controllers;

import com.dev.Objects.Entities.Seller;
import com.dev.Services.GeneralManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class LoginController {

    @Autowired
    private GeneralManager generalManager;

    @RequestMapping("/login-page")
    public String loginPage(Model model) {
        return "tmpl_login";
    }

    @RequestMapping("/login")
    @ResponseBody
    public String login(String userName, String password) {
        List<Seller> sellerList = generalManager.getList(Seller.class);
        String pass = String.valueOf(password);
        for (Seller s : sellerList) {
            if (s.getName().equals(userName) &&
                    s.getPassword().equals(password)) {
                return "OK";
            }
        }
        return "ERROR";
    }


}

