package com.fpoly.agile.service;

import com.fpoly.agile.model.Category;
import com.fpoly.agile.model.Products;
import com.fpoly.agile.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("CategoryService")
@Transactional
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return (List<Category>) categoryRepository.findAll();
    }

    @Override
    public void save(Category category){
        categoryRepository.save(category);
    }

    @Override
    public void delete(Integer CategoryID){
        categoryRepository.deleteById(CategoryID);
    }

    @Override
    public Category get(Integer CategoryID){
        return categoryRepository.findById(CategoryID).get();
    }

    @Override
    public Category find(Integer CategoryID) {
        return categoryRepository.find(CategoryID);
    }


}
