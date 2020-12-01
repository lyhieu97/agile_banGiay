package com.fpoly.agile.service;

import com.fpoly.agile.model.News;
import com.fpoly.agile.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("NewsService")
@Transactional
public class NewsServiceImpl implements NewsService {
    @Autowired
    NewsRepository newsRepository;

    @Override
    public List<News> findAll() {
        return (List<News>) newsRepository.findAll();
    }

    @Override
    public void save(News news){
        newsRepository.save(news);
    }

    @Override
    public void delete(Integer NewsID){
        newsRepository.deleteById(NewsID);
    }

    @Override
    public News get(Integer NewsID){
        return newsRepository.findById(NewsID).get();
    }

    @Override
    public News find(Integer NewsID) {
        return newsRepository.find(NewsID);
    }
}
