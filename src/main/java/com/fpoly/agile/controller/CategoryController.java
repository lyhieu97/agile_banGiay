package com.fpoly.agile.controller;

import com.fpoly.agile.model.Category;
import com.fpoly.agile.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/category")
    public ModelAndView listCategory(){
        ModelAndView modelAndView = new ModelAndView("Admin/Category/List", "category", categoryService.findAll());
        return modelAndView;
    }

    @GetMapping("/categorycreate")
    public ModelAndView saveProduct(){
        ModelAndView modelAndView = new ModelAndView("Admin/Category/Create");
        modelAndView.addObject("category", new Category());
        return modelAndView;
    }

    @PostMapping("/categorycreate")
    public ModelAndView saveProduct(@ModelAttribute("category")Category category) {
        categoryService.save(category);
        ModelAndView modelAndView = new ModelAndView("Admin/Category/Create");
        modelAndView.addObject("message", "Category: " + category.getName() + " create successfully !");
        return modelAndView;
    }

    @GetMapping("/categorydelete/{CategoryID}")
    public String delete(@PathVariable Integer CategoryID, Model model){
        model.addAttribute("category", categoryService.get(CategoryID));
        return "Admin/Category/Delete";
    }
    @PostMapping("/categorydelete")
    public ModelAndView delete(@ModelAttribute("category") Category category){
        categoryService.delete(category.getCategoryID());
        ModelAndView modelAndView = new ModelAndView("Admin/Category/Delete");
        modelAndView.addObject("message", "Category name " + category.getName() + " deleted successfully !");
        return modelAndView;
    }

    @GetMapping("/categoryupdate/{CategoryID}")
    public String edit(@PathVariable Integer CategoryID, Model model){
        model.addAttribute("category", categoryService.get(CategoryID));
        return "Admin/Category/Update";
    }
    @PostMapping("/categoryupdate")
    public ModelAndView update(@ModelAttribute("category") Category category){
        categoryService.save(category);
        ModelAndView modelAndView = new ModelAndView("Admin/Category/Update");
        modelAndView.addObject("message", "Category id: " + category.getCategoryID() + " updated successfully !");
        return modelAndView;
    }
}
