package com.fpoly.agile.service;


import com.fpoly.agile.model.FavoriteList;
import com.fpoly.agile.repository.FavoriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("FavoriteService")
@Transactional
public class FavoriteServiceImpl implements FavoriteService {
    @Autowired
    FavoriteRepository favoriteRepository;

    @Override
    public List<FavoriteList> findAll() {
        return (List<FavoriteList>) favoriteRepository.findAll();
    }

    @Override
    public void save(FavoriteList favoriteList){
        favoriteRepository.save(favoriteList);
    }

    @Override
    public void delete(Integer FavoriteID){
        favoriteRepository.deleteById(FavoriteID);
    }

    @Override
    public FavoriteList get(Integer FavoriteID){
        return favoriteRepository.findById(FavoriteID).get();
    }

    @Override
    public FavoriteList find(Integer FavoriteID) {
        return favoriteRepository.find(FavoriteID);
    }
}
