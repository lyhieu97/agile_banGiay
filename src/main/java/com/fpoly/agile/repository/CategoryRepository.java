package com.fpoly.agile.repository;

import com.fpoly.agile.model.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Integer> {

    @Query("select a from Category a where a.CategoryID = :CategoryID")
    public Category find(Integer CategoryID);
}
