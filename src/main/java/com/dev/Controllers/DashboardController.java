package com.dev.Controllers;

import com.dev.Services.GeneralManager;
import com.dev.Utils.ConfigUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;


@Controller
public class DashboardController {

    @RequestMapping("/dasboard")
    public String dashboard() {
        return "tmpl_dashbonard";
    }

}
