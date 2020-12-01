package com.fpoly.agile.repository;

import com.fpoly.agile.model.News;
import com.fpoly.agile.model.Products;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface NewsRepository extends CrudRepository<News, Integer> {
    @Query("select a from News a where a.NewsID = :NewsID")
    public News find(Integer NewsID);
}
