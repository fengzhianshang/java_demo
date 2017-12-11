package com.example.demo.service;

import com.example.demo.entity.Article;

import java.util.List;

public interface ArticleService {

  List<Article> findAll();

  Article findOne(Integer id);

  void delete(Integer id);

  Article save(Article article);
}
