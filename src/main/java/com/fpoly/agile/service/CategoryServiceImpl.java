package com.fpoly.agile.service;

import com.fpoly.agile.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("CategoryService")
@Transactional
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryService categoryService;

    @Override
    public List<Category> findAll() {
        return (List<Category>) categoryService.findAll();
    }

    @Override
    public void save(Category category){
        categoryService.save(category);
    }

    @Override
    public void delete(Integer CategoryID){
        categoryService.delete(CategoryID);
    }

    @Override
    public Category get(Integer CategoryID){
        return categoryService.get(CategoryID);
    }

    @Override
    public Category find(Integer CategoryID) {
        return categoryService.find(CategoryID);
    }
}
