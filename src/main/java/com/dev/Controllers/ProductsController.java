package com.dev.Controllers;

import com.dev.Objects.Entities.Product;
import com.dev.Services.GeneralManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ProductsController {
    @Autowired
    private GeneralManager generalManager;
    @RequestMapping("/product/{oid}")
    public String about(Model model, @PathVariable int oid) {
        Product product = generalManager.loadObject(Product.class, oid);
        List<Product> allProducts =  generalManager.loadList(Product.class);
        model.addAttribute("products", allProducts);
        if (product != null) {
            model.addAttribute("products", product);
        } else {
            model.addAttribute("error", true);
        }

        return "tmpl_products";
    }
}
