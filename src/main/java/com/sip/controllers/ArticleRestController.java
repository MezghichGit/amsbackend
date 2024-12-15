package com.sip.controllers;

import com.sip.entities.Article;
import com.sip.services.ArticleService;

import org.springframework.beans.factory.annotation.Autowired;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/articles")
public class ArticleRestController {

	@Autowired
	private ArticleService articleService;

	// Get all articles
	@GetMapping
	public List<Article> getAllArticles() {
		return articleService.getAllArticles();
	}

	// Get a single article by ID
	@GetMapping("/{id}")
	public Article getArticleById(@PathVariable Long id) {
		return articleService.getArticleById(id);
	}

	// Create a new article
	@PostMapping
	public Article createArticle(@Valid @RequestBody Article article) {
		return articleService.addArticle(article);
	}

	// Update an existing article
	@PutMapping("/{id}")
	public Article updateArticle(@PathVariable Long id, @Valid @RequestBody Article article) {
		return articleService.updateArticle(id, article);
	}

	// Delete an article by ID
	@DeleteMapping("/{id}")
	public Article deleteArticle(@PathVariable Long id) {
		return articleService.deleteArticle(id);
	}
}
