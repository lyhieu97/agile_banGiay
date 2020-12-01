package com.fpoly.agile.service;

import com.fpoly.agile.model.FavoriteList;

import java.util.List;

public interface FavoriteService {
    public List<FavoriteList> findAll();
    public void save(FavoriteList favoriteList);
    public void delete(Integer CategoryID);
    public FavoriteList get(Integer CategoryID);
    public FavoriteList find(Integer CategoryID);
}
