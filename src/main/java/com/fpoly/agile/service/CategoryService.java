package com.fpoly.agile.service;

import com.fpoly.agile.model.Category;

import java.util.List;

public interface CategoryService {
    public List<Category> findAll();
    public void save(Category category);
    public void delete(Integer CategoryID);
    public Category get(Integer CategoryID);
    public Category find(Integer CategoryID);
}
