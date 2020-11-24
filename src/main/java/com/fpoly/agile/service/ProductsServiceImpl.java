package com.fpoly.agile.service;

import com.fpoly.agile.model.Products;
import com.fpoly.agile.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("ProductsService")
@Transactional
public class ProductsServiceImpl implements ProductsService {
    @Autowired
    ProductsRepository productsRepository;

    @Override
    public List<Products> findAll() {
        return (List<Products>) productsRepository.findAll();
    }

    @Override
    public void save(Products product){
        productsRepository.save(product);
    }

    @Override
    public void delete(Integer ProductsID){
        productsRepository.deleteById(ProductsID);
    }

    @Override
    public Products get(Integer ProductsID){
        return productsRepository.findById(ProductsID).get();
    }

    @Override
    public Products find(Integer ProductsID) {
        return productsRepository.find(ProductsID);
    }
}
