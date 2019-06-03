package com.dev.Controllers;

import com.dev.Objects.Entities.Ticket;
import com.dev.Services.GeneralManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class DrawController {

    @Autowired
    private GeneralManager generalManager;

    @RequestMapping("/draw/{oid}")
    public String draw(HttpServletRequest request, Model model, @PathVariable int oid) {
        Ticket ticket = generalManager.loadObject(Ticket.class,oid);
        if (ticket != null) {
            model.addAttribute("ticket", ticket);
        } else {
            model.addAttribute("error", true);
        }
        return "tmpl_draw";
    }
}
