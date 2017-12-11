package com.example.demo.controller;

import com.example.demo.entity.Article;
import com.example.demo.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/articles")
public class ArticleController {

  @Autowired
  private ArticleService articleService;

  @GetMapping(value = "")
  public List<Article> index() {
    return articleService.findAll();
  }

  @PostMapping(value = "/create")
  public Article create(@RequestParam("title") String title,
                        @RequestParam("content" ) String content) {

    Article article = new Article();
    Date now = new Date();
    article.setTitle(title);
    article.setContent(content);
    article.setCreatedAt(now);
    article.setUpdatedAt(now);

    return articleService.save(article);
  }

  @GetMapping(value = "/{id}")
  public Article findOne (@PathVariable("id") Integer id) {
    return articleService.findOne(id);
  }

  @PutMapping(value = "/update/{id}")
  public Article update(@PathVariable("id") Integer id,
                        @RequestParam("title") String title,
                        @RequestParam("content") String content) {
    Article article = articleService.findOne(id);
    article.setTitle(title);
    article.setContent(content);
    article.setUpdatedAt(new Date());

    return articleService.save(article);
  }

  @DeleteMapping(value = "/delete/{id}")
  public void delete(@PathVariable("id") Integer id) {
    articleService.delete(id);
  }
}
