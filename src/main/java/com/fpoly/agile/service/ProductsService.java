package com.fpoly.agile.service;

import com.fpoly.agile.model.Products;

import java.util.List;

public interface ProductsService {
    public List<Products> findAll();
    public void save(Products product);
    public void delete(Integer ProductsID);
    public Products get(Integer ProductsID);
    public Products find(Integer ProductsID);
}
