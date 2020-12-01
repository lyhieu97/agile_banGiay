package com.fpoly.agile.controller;

import com.fpoly.agile.model.News;
import com.fpoly.agile.repository.NewsRepository;
import com.fpoly.agile.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NewsController {

    @Autowired

    private NewsService newsService;

    @GetMapping("/news")
    public String listnews(ModelMap modelMap){
        modelMap.put("news", newsService.findAll());
        return "Admin/News/List";
    }
    @GetMapping("/news1")
    public String NewsPage(ModelMap modelMap) {
        modelMap.put("News", newsService.findAll());
        return "Page/View/News";
    }

    @GetMapping("/newsupdate/{NewsID}")
    public String edit(@PathVariable Integer NewsID, Model model){
        model.addAttribute("news", newsService.get(NewsID));
        return "Admin/News/Update";
    }
    @PostMapping("/newsupdate")
    public ModelAndView update(@ModelAttribute("news") News news, ModelMap modelMap){
        newsService.save(news);
        ModelAndView modelAndView = new ModelAndView("Admin/News/Update");
        modelMap.put("message", "updated successful !");
        return modelAndView;
    }

    @GetMapping("/newsdelete/{NewsID}")
    public String delete(@PathVariable Integer NewsID, Model model){
        model.addAttribute("news", newsService.get(NewsID));
        return "Admin/News/Delete";
    }
    @PostMapping("/newsdelete")
    public ModelAndView delete(@ModelAttribute("news") News news,ModelMap modelMap) {
        newsService.delete(news.getNewsID());
        ModelAndView modelAndView = new ModelAndView("Admin/News/Delete");
        modelMap.put("message", "deleted successful !");
        return modelAndView;
    }
    @GetMapping("/newscreate")
    public ModelAndView saveNews(){
        ModelAndView modelAndView = new ModelAndView("Admin/News/Create");
        modelAndView.addObject("news", new News());
        return modelAndView;
    }

    @PostMapping("/newscreate")
    public ModelAndView saveNews(@ModelAttribute("news") News news,ModelMap modelMap){
        newsService.save(news);
        ModelAndView modelAndView = new ModelAndView("Admin/News/Create");
        modelAndView.addObject("news", new News());
        modelMap.put("message", "created successful !");
        return modelAndView;
    }
}
