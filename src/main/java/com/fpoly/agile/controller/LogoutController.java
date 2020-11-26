package com.fpoly.agile.controller;

import com.fpoly.agile.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
@Controller
public class LogoutController {

    @Autowired
    ProductsRepository productsRepository;



    @GetMapping("/logout")
    public ModelAndView logout(HttpSession session, ModelMap modelMap){
        ModelAndView modelAndView = new ModelAndView("Page/view/Home1");
        session.removeAttribute("Email");
        session.removeAttribute("cart");
        modelMap.put("message", "logout successful you have successfully logged out !");
        modelMap.put("Products", productsRepository.findAll());
        return modelAndView;
    }
}
