package com.example.demo.service.impl;

import com.example.demo.entity.Article;
import com.example.demo.repository.ArticleRepository;
import com.example.demo.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImple implements ArticleService {

  @Autowired
  private ArticleRepository articleRepository;

  @Override
  public List<Article> findAll() {
    return articleRepository.findAll();
  }

  @Override
  public  Article save(Article article) { return articleRepository.save(article); }

  @Override
  public Article findOne(Integer id) {
    return articleRepository.findOne(id);
  }

  @Override
  public void delete(Integer id) {
    articleRepository.delete(id);
  }
}
