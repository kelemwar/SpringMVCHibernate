package org.SimpleBlog.service;

import java.util.List;

import org.SimpleBlog.dao.ArticleDAO;
import org.SimpleBlog.model.Article;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Service
public class ArticleServiceImpl implements ArticleService {
	
	private ArticleDAO articleDAO;

	public void setArticleDAO(ArticleDAO articleDAO) {
		this.articleDAO = articleDAO;
	}

	@Override
	@Transactional
	public void addArticle(Article article) {
		this.articleDAO.addArticle(article);
	}

	@Override
	@Transactional
	public void updateArticle(Article article) {
		this.articleDAO.updateArticle(article);
	}

	@Override
	@Transactional
	public List<Article> listArticles() {
		return this.articleDAO.listArticle();
	}

	@Override
	@Transactional
	public List<Article> searchArticles(String searchString) {
		return this.articleDAO.searchArticle(searchString);
	}

	@Override
	@Transactional
	public Article getArticleById(int id) {
		return this.articleDAO.getArticleById(id);
	}

	@Override
	@Transactional
	public void removeArticle(int id) {
		this.articleDAO.removeArticle(id);
	}


}
