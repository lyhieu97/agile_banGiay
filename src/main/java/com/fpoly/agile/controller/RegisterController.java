package com.fpoly.agile.controller;

import com.fpoly.agile.model.Users;
import com.fpoly.agile.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegisterController {

    @Autowired
    private UsersService service;


    @GetMapping("/register")
    public ModelAndView register(){
        ModelAndView modelAndView = new ModelAndView("Register");
        modelAndView.addObject("users", new Users());
        return modelAndView;
    }

    @PostMapping("/register")
    public String saveUser(@ModelAttribute("users") Users user, Model model){
        service.save(user);
        model.addAttribute("user", new Users());
        model.addAttribute("message", "Register username: " + user.getEmail()+ " and password: " + user.getPass() + " successfully !");
        return "Register";
    }
}
