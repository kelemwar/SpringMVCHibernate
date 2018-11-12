package org.SimpleBlog.dao;

import java.util.List;

import org.SimpleBlog.model.Article;

public interface ArticleDAO {

	 void addArticle(Article article);
	 void updateArticle(Article article);
	 List<Article> listArticle();
	 List<Article> searchArticle(String searchString);
	 Article getArticleById(int id);
	 void removeArticle(int id);
}
