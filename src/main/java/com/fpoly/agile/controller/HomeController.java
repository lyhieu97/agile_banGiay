package com.fpoly.agile.controller;

import com.fpoly.agile.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private ProductsRepository productsRepository;

    @GetMapping("/")
    public String HomePage(ModelMap modelMap){
        modelMap.put("Products", productsRepository.findAll());
        return "Home";
    }
}
