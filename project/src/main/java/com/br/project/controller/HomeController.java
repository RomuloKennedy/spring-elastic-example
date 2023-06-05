package com.br.project.controller;

import com.br.project.model.Article;
import com.br.project.model.Author;

import com.br.project.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping
    @ResponseBody
    public Page<Article> home(){

        Article article = new Article();
        article.setTitle("Spring Data Elasticsearch");
        article.setAuthors(Arrays.asList(new Author("John Smith"), new Author("John Doe")));
        articleRepository.save(article);

        String nameToFind = "John Smith";
        Page<Article> articleByAuthorName
                = articleRepository.findByAuthorsNameUsingCustomQuery(nameToFind, PageRequest.of(0, 10));

        return articleByAuthorName;
    }

}
