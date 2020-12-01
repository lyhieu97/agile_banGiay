package com.fpoly.agile.controller;

import com.fpoly.agile.model.Item;
import com.fpoly.agile.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("favorite")
public class FavoriteController {

    @Autowired
    private ProductsRepository productsRepository;

   @RequestMapping(method = RequestMethod.GET)
    public String favorite(){
        return "Page/View/Favorite";
    }

    @RequestMapping(value = "favorite/{ProductsID}", method = RequestMethod.GET)
    public String addfv(@PathVariable("ProductsID") Integer ProductsID, HttpSession session){
        if(session.getAttribute("favorite") == null){
            List<Item> favorite = new ArrayList<Item>();
            favorite.add(new Item(productsRepository.find(ProductsID)));
            session.setAttribute("favorite", favorite);
        }else{
            List<Item> favorite = (List<Item>) session.getAttribute("favorite");
            int index = isExists(ProductsID, favorite);
            if(index == -1){
                favorite.add(new Item(productsRepository.find(ProductsID)));
            }
            session.setAttribute("favorite", favorite);
        }
        return "Page/View/Favorite";
    }
    @RequestMapping(value = "delete/{ProductsID}", method = RequestMethod.GET)
    public String delete(@PathVariable("ProductsID") Integer ProductsID, HttpSession session){
        List<Item> favorite = (List<Item>) session.getAttribute("favorite");
        int index = isExists(ProductsID, favorite);
        favorite.remove(index);
        session.setAttribute("favorite", favorite);
        return "Page/View/Favorite";
    }

    private int isExists(int id, List<Item> favorite){
        for (int i = 0; i < favorite.size(); i++){
            if(favorite.get(i).getProducts().getProductsID()==id){
                return i;
            }
        }
        return -1;
    }
}
