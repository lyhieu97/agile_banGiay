package com.fpoly.agile.controller;

import com.fpoly.agile.model.Users;
import com.fpoly.agile.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class UsersController {
    @Autowired
    private UsersService service;

    @GetMapping("/userslist")
    public ModelAndView testPage(){
        ModelAndView modelAndView = new ModelAndView("Admin/Users/List", "users", service.findAll());
        return modelAndView;
    }

    @GetMapping("/usersupdate/{UsersID}")
    public String edit(@PathVariable Integer UsersID, Model model){
        model.addAttribute("users", service.get(UsersID));
        return "Admin/Users/Update";
    }
    @PostMapping("/usersupdate")
    public ModelAndView update(@ModelAttribute("users") Users user, ModelMap modelMap){
        service.save(user);
        ModelAndView modelAndView = new ModelAndView("Admin/Users/Update");
        modelMap.put("message", "updated successful !");
        return modelAndView;
    }

    @GetMapping("/usersdelete/{UsersID}")
    public String delete(@PathVariable Integer UsersID, Model model){
        model.addAttribute("users", service.get(UsersID));
        return "Admin/Users/Delete";
    }
    @PostMapping("/usersdelete")
    public ModelAndView delete(@ModelAttribute("users") Users user,ModelMap modelMap) {
            service.delete(user.getUsersID());
            ModelAndView modelAndView = new ModelAndView("Admin/Users/Delete");
            modelMap.put("message", "deleted successful !");
            return modelAndView;
    }
    @GetMapping("/userscreate")
    public ModelAndView saveUser(){
        ModelAndView modelAndView = new ModelAndView("Admin/Users/Create");
        modelAndView.addObject("users", new Users());
        return modelAndView;
    }

    @PostMapping("/userscreate")
    public ModelAndView saveUser(@ModelAttribute("users") Users users,ModelMap modelMap){
        service.save(users);
        ModelAndView modelAndView = new ModelAndView("Admin/Users/Create");
        modelAndView.addObject("users", new Users());
        modelMap.put("message", "created successful !");
        return modelAndView;
    }
}
