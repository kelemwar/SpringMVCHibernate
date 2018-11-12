package org.SimpleBlog.service;

import java.util.List;

import org.SimpleBlog.model.Article;

public interface ArticleService {

	 void addArticle(Article article);
	 void updateArticle(Article article);
	 List<Article> listArticles();
	 List<Article> searchArticles(String searchString);
	 Article getArticleById(int id);
	 void removeArticle(int id);

}
