package com.dev.Controllers;

import com.dev.Services.GeneralManager;
import com.dev.Utils.ConfigUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;


@Controller
public class DashboardController {

    @RequestMapping("/dasboard")
    public String dashboard(String userName, Model model) {
        model.addAttribute("userName",userName);
        return "tmpl_dashboard";
    }


}
