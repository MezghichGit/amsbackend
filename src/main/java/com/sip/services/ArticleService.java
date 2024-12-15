package com.sip.services;

import com.sip.entities.Article;
import com.sip.repositories.ArticleRepository;
import com.sip.exceptions.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

	@Autowired
	private ArticleRepository articleRepository;

	// Retrieve all articles
	public List<Article> getAllArticles() {
		return articleRepository.findAll();
	}

	// Retrieve an article by ID
	public Article getArticleById(Long id) {
		return articleRepository.findById(id).map(a -> {
			return a;
		}).orElseThrow(() -> new ResourceNotFoundException("Article with Id " + id + " was not found"));
	}

	// Save a new article
	public Article addArticle(Article article) {
		return articleRepository.save(article);
	}

	// Update an existing article
	public Article updateArticle(Long id, Article newArticle) {
		return articleRepository.findById(id).map(existingArticle -> {
			existingArticle.setLabel(newArticle.getLabel());
			existingArticle.setPrice(newArticle.getPrice());
			existingArticle.setPicture(newArticle.getPicture());
			existingArticle.setProvider(newArticle.getProvider());
			return articleRepository.save(existingArticle);
		}).orElseThrow(() -> new ResourceNotFoundException("Article with Id " + id + " was not found"));
	}

	// Delete an article by ID
	public Article deleteArticle(Long id) {
		return articleRepository.findById(id).map(a -> {
			articleRepository.delete(a);
			return a;
		}).orElseThrow(() -> new ResourceNotFoundException("Article with Id " + id + " was not found"));
	}
}
