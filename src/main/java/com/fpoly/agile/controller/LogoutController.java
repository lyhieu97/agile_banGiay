package com.fpoly.agile.controller;


import com.fpoly.agile.model.Users;
import com.fpoly.agile.repository.ProductsRepository;
import com.fpoly.agile.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;


import javax.servlet.http.HttpSession;
@Controller
public class LogoutController {

    @Autowired
    ProductsRepository productsRepository;
    private UsersService usersService;

    @GetMapping("/logout")
    public String logout(HttpSession session, ModelMap modelMap, Users users) {
        session.removeAttribute("Email");
        session.removeAttribute("favorite");
        modelMap.put("message", "logout successful you have successfully logged out !");
        modelMap.put("Products", productsRepository.findAll());
        return "Page/view/Home1";
    }
}
