package com.fpoly.agile.repository;

import com.fpoly.agile.model.FavoriteList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface FavoriteRepository extends CrudRepository<FavoriteList, Integer> {
    @Query("select a from FavoriteList a where a.FavoriteID = :FavoriteID")
    public FavoriteList find(Integer FavoriteID);
}
