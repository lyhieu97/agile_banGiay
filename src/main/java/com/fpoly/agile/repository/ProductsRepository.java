package com.fpoly.agile.repository;

import com.fpoly.agile.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductsRepository extends CrudRepository<Products, Integer> {

    @Query("select a from Products a where a.ProductsID = :ProductsID")
    public Products find(Integer ProductsID);

//    @Query("select a from Products a where a.CategoryID = :CategoryID")
//    public Products findbyCategoryID(Integer CategoryID);
//
//    @Query("select a from Products a order by a.Price asc")
//    public Products sortByPrice(Integer Price);

    @Query("select p from Products p where p.Name like %?1%")
    public List<Products> findAll(String keyword);

    @Query("select p from Products p where p.CategoryID = :CategoryID")
    public List<Products> findAll(Integer CategoryID);

    @Query("select p from Products p ORDER BY p.Price asc ")
    public List<Products> findAllOrOrderByPriceAsc();
}
