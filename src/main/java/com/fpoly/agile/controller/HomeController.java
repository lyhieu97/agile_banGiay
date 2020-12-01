package com.fpoly.agile.controller;

import com.fpoly.agile.model.Products;
import com.fpoly.agile.repository.NewsRepository;
import com.fpoly.agile.repository.ProductsRepository;
import com.fpoly.agile.service.NewsService;
import com.fpoly.agile.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private ProductsService productsService;
    private NewsRepository newsRepository;

    @GetMapping("/")
    public String HomePage(ModelMap modelMap) {
        modelMap.put("Products", productsService.findAll());
        return "Page/View/Home1";
    }

    @GetMapping("/home")
    public String HomePage1(ModelMap modelMap) {
        modelMap.put("Products", productsService.findAll());
        return "Page/View/Home";
    }

    @GetMapping("/admin")
    public String AdminPage() {
        return "Admin/View/Home";
    }

//    @GetMapping("/news1")
//    public String NewsPage(ModelMap modelMap) {
//        modelMap.put("News", newsRepository.findAll());
//        return "Page/View/News";
//    }

    @GetMapping("/products")
    public String all(ModelMap modelMap,@Param("keyword") String keyword) {
        List<Products> products = productsService.findAll(keyword);
        modelMap.put("products",products );
        return "Page/View/Products";
    }
//    @GetMapping("/productsorbypriceasc")
//    public List<Products> getProductsByPrice(){
//        return productsService.findAllOrOrderByPriceAsc();
//    }

//    @GetMapping("/category")
//    public String all1(ModelMap modelMap,@Param("categoryID") Integer categoryID){
//        List<Products> products = productsService.findAll(categoryID);
//        modelMap.put("products",products );
//        return "Page/View/Products";
//    }
}
