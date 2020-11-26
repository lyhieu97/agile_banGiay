package com.fpoly.agile.controller;

import com.fpoly.agile.model.Products;
import com.fpoly.agile.model.Users;
import com.fpoly.agile.service.ProductsService;
import com.fpoly.agile.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductsController {
    @Autowired
    private ProductsService service;

    @GetMapping("/productslist")
    public ModelAndView testPage(){
        ModelAndView modelAndView = new ModelAndView("Admin/Products/List", "products", service.findAll());
        return modelAndView;
    }

    @GetMapping("/productsupdate/{ProductsID}")
    public String edit(@PathVariable Integer ProductsID, Model model){
        model.addAttribute("products", service.get(ProductsID));
        return "Admin/Products/Update";
    }
    @PostMapping("/productsupdate")
    public ModelAndView update(@ModelAttribute("products") Products products){
        service.save(products);
        ModelAndView modelAndView = new ModelAndView("Admin/Products/Update");
        modelAndView.addObject("message", "Products id: " + products.getProductsID() + " updated successfully !");
        return modelAndView;
    }

    @GetMapping("/productsdelete/{ProductsID}")
    public String delete(@PathVariable Integer ProductsID, Model model){
        model.addAttribute("products", service.get(ProductsID));
        return "Admin/Products/Delete";
    }
    @PostMapping("/productsdelete")
    public ModelAndView delete(@ModelAttribute("products") Products products){
        service.delete(products.getProductsID());
        ModelAndView modelAndView = new ModelAndView("Admin/Products/Delete");
        modelAndView.addObject("message", "Products name " + products.getName() + " deleted successfully !");
        return modelAndView;
    }

    @GetMapping("/productscreate")
    public ModelAndView saveProduct(){
        ModelAndView modelAndView = new ModelAndView("Admin/Products/Create");
        modelAndView.addObject("products", new Products());
        return modelAndView;
    }

    @PostMapping("/productscreate")
    public ModelAndView saveProduct(@ModelAttribute("products")Products products) {
        service.save(products);
        ModelAndView modelAndView = new ModelAndView("Admin/Products/Create");
        modelAndView.addObject("message", "Products: " + products.getName() + " create successfully !");
        return modelAndView;
    }
}
