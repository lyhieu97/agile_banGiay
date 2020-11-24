package com.fpoly.agile.controller;

import com.fpoly.agile.model.Users;
import com.fpoly.agile.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UsersController {
//Cai commit nay ko ok, ban nay` kieu gi y de tai ban # cu de day da ko can tai dau
    @Autowired
    private UsersService service;

    @GetMapping("/userslist")
    public ModelAndView testPage(){
        ModelAndView modelAndView = new ModelAndView("UsersList", "users", service.findAll());
        return modelAndView;
    }

    @GetMapping("/usersupdate/{UsersID}")
    public String edit(@PathVariable Integer UsersID, Model model){
        model.addAttribute("users", service.get(UsersID));
        return "Usersupdate";
    }
    @PostMapping("/usersupdate")
    public ModelAndView update(@ModelAttribute("users") Users user){
        service.save(user);
        ModelAndView modelAndView = new ModelAndView("UsersUpdate");
        modelAndView.addObject("message", "Users id: " + user.getUsersID() + " updated successfully !");
        return modelAndView;
    }

    @GetMapping("/usersdelete/{UsersID}")
    public String delete(@PathVariable Integer UsersID, Model model){
        model.addAttribute("users", service.get(UsersID));
        return "Usersdelete";
    }
    @PostMapping("/usersdelete")
    public ModelAndView delete(@ModelAttribute("users") Users user){
        service.delete(user.getUsersID());
        ModelAndView modelAndView = new ModelAndView("UsersDelete");
        modelAndView.addObject("message", "Users name " + user.getFullName() + " deleted successfully !");
        return modelAndView;
    }

    @GetMapping("/userscreate")
    public ModelAndView saveUser(){
        ModelAndView modelAndView = new ModelAndView("UsersCreate");
        modelAndView.addObject("users", new Users());
        return modelAndView;
    }

    @PostMapping("/userscreate")
    public ModelAndView saveUser(@ModelAttribute("users") Users users){
        service.save(users);
        ModelAndView modelAndView = new ModelAndView("UsersCreate");
        modelAndView.addObject("users", new Users());
        modelAndView.addObject("message", "User: " + users.getFullName() + " create successfully!");
        return modelAndView;
    }
}
