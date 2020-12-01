package com.fpoly.agile.service;

import com.fpoly.agile.model.News;

import java.util.List;

public interface NewsService {
    public List<News> findAll();
    public void save(News news);
    public void delete(Integer NewsID);
    public News get(Integer NewsID);
    public News find(Integer NewsID);
}
