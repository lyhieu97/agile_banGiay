package com.fpoly.agile.controller;

import com.fpoly.agile.model.Products;
import com.fpoly.agile.repository.ProductsRepository;
import com.fpoly.agile.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProductsController {
    @Autowired
    private ProductsService productsService;
    private ProductsRepository productsRepository;

    @GetMapping("/productslist")
    public ModelAndView testPage(){
        ModelAndView modelAndView = new ModelAndView("Admin/Products/List", "products", productsService.findAll());
        return modelAndView;
    }

    @GetMapping("/productsupdate/{ProductsID}")
    public String edit(@PathVariable Integer ProductsID, Model model){
        model.addAttribute("products", productsService.get(ProductsID));
        return "Admin/Products/Update";
    }
    @PostMapping("/productsupdate")
    public ModelAndView update(@ModelAttribute("products") Products products){
        productsService.save(products);
        ModelAndView modelAndView = new ModelAndView("Admin/Products/Update");
        modelAndView.addObject("message", "Products id: " + products.getProductsID() + " updated successfully !");
        return modelAndView;
    }

    @GetMapping("/productsdelete/{ProductsID}")
    public String delete(@PathVariable Integer ProductsID, Model model){
        model.addAttribute("products", productsService.get(ProductsID));
        return "Admin/Products/Delete";
    }
    @PostMapping("/productsdelete")
    public ModelAndView delete(@ModelAttribute("products") Products products){
        productsService.delete(products.getProductsID());
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
        productsService.save(products);
        ModelAndView modelAndView = new ModelAndView("Admin/Products/Create");
        modelAndView.addObject("message", "Products: " + products.getName() + " create successfully !");
        return modelAndView;
    }

    @GetMapping("/productsdetail/{ProductsID}")
    public String detail(@PathVariable Integer ProductsID, Model model, ModelMap modelMap){
        model.addAttribute("products", productsService.get(ProductsID));
        modelMap.put("Products", productsService.findAll());
        return "Page/View/ProductsDetail";
    }

//    @GetMapping("/productsdetail/{ProductsID}")//thay doi duong dan sang views lay duoc iD product
//    public String favorite(@PathVariable Integer ProductsID, Model model){//khai bao model favorite
//        //save ProductsID vao favorite;
//        model.addAttribute("products", productsService.get(favorite.id));
//
//        return "Page/View/ProductsDetail";
//    }
}
