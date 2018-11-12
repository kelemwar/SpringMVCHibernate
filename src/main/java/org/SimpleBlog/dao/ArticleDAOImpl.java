package org.SimpleBlog.dao;

import java.util.List;

import org.SimpleBlog.model.Article;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class ArticleDAOImpl implements ArticleDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(ArticleDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addArticle(Article article) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(article);

		logger.info("Article saved successfully, Article Details="+article);
	}

	@Override
	public void updateArticle(Article article) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(article);
		logger.info("Article updated successfully, Article Details="+article);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Article> listArticle() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Article> articlesList = session.createQuery("from Article").list();
		for(Article article : articlesList){
			logger.info("Article List::"+article);
		}
		return articlesList;

	}

	@Override
	public List<Article> searchArticle(String searchString) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query =  session.createQuery("from Article where category = "+"'"+searchString+"'");
		List<Article> articlesList = query.list();
		for (Article article : articlesList){
			logger.info("Article search List::"+article);
		}
		return articlesList;
	}

	@Override
	public Article getArticleById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Article article = (Article) session.load(Article.class, new Integer(id));
		logger.info("Article loaded successfully, Article details="+article);
		return article;
	}

	@Override
	public void removeArticle(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Article article = (Article) session.load(Article.class, new Integer(id));
		if(null != article){
			session.delete(article);
		}
		logger.info("Article deleted successfully, article details="+article);
	}

}
