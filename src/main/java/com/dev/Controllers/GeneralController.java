package com.dev.Controllers;


import com.dev.Services.GeneralManager;
import com.dev.Utils.ConfigUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

import java.util.HashMap;
import java.util.Map;

import static com.dev.Utils.Definitions.*;

@CrossOrigin
@Controller
public class GeneralController {

    private static final Logger LOGGER = LoggerFactory.getLogger(GeneralController.class);

    @Autowired
    private ConfigUtils configUtils;

    @Autowired
    private GeneralManager generalManager;

    private static final int PAGE_MAIN = 0;

    private static final Map<Integer, String> PAGES_NAMES = new HashMap<>();
    static {
        PAGES_NAMES.put(PAGE_MAIN, "עמוד ראשי");
    }


    @ModelAttribute
    public void preProcess (HttpServletRequest request, Model model) {
        LOGGER.info(String.format("request: %s", request.getRequestURI()));
        model.addAttribute("pagesNames", PAGES_NAMES);

    }

    @RequestMapping("/")
    public String main(Model model) throws Exception {
        model.addAttribute("page", PAGE_MAIN);
        boolean error = false;
        Integer code = null;
        try {
            model.addAttribute(PARAM_NAME, "TEST");
        } catch (Exception e) {
            LOGGER.error("main", e);
            error = true;
            code = PARAM_ERROR_GENERAL;
        }
        model.addAttribute(PARAM_ERROR, error);
        model.addAttribute(PARAM_CODE, code);

        return "tmpl_main";
    }


}
