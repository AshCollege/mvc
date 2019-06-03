package com.dev.Controllers;

import com.dev.Objects.Entities.Product;
import com.dev.Objects.Entities.Seller;
import com.dev.Persist;
import com.dev.Services.GeneralManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class SellerController {

    @Autowired
    private GeneralManager generalManager;

    @Autowired
    private Persist persist;

    @RequestMapping("/seller/{oid}")
    public String about(Model model, @PathVariable int oid) {
        Seller seller = generalManager.loadObject(Seller.class, oid);
        List<Product> products = persist.loadProductBySeller(oid);
        model.addAttribute("products",products);
        if (seller != null) {
            model.addAttribute("seller", seller);
        } else {
            model.addAttribute("error", true);
        }

        return "tmpl_seller";
    }

    @RequestMapping("/sellers")
    public String about1(Model model1) {
        List<Seller> allSelers =  generalManager.loadList(Seller.class);
        model1.addAttribute("sellers", allSelers);
        return "tmpl_sellers";
    }
}
