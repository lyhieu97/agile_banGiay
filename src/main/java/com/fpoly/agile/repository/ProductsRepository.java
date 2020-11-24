package com.fpoly.agile.repository;

import com.fpoly.agile.model.Products;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ProductsRepository extends CrudRepository<Products, Integer> {

    @Query("select a from Products a where a.ProductsID = :ProductsID")
    public Products find(Integer ProductsID);
}
