package com.fpoly.agile.controller;

import com.fpoly.agile.model.Users;
import com.fpoly.agile.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UsersService userService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView("Page/View/Login");
        modelAndView.addObject("users", new Users());
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String login(@ModelAttribute("users") Users users, HttpSession session, ModelMap modelMap){
        if(userService.login(users.getEmail(), users.getPass()) != null){
            session.setAttribute("Email", users.getEmail());
            session.setAttribute("Pass", users.getPass());
            return "redirect:/home";
        }else {
            modelMap.put("message", "User's Invalid !");
            return "Page/View/Login";
        }
    }

//    @RequestMapping(value = "logout",method = RequestMethod.GET)
//    public String logout(HttpSession session, ModelMap modelMap){
//        session.removeAttribute("Email");
//        session.removeAttribute("cart");
//        modelMap.put("message", "Logout succes !");
//        return "redirect:/";
//    }
}
