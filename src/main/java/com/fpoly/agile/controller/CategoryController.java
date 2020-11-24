package com.fpoly.agile.controller;

import com.fpoly.agile.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("category/")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("list")
    public ModelAndView listCategory(){
        ModelAndView modelAndView = new ModelAndView("category/list", "category", categoryService.findAll());
        return modelAndView;
    }
}
