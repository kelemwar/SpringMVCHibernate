package org.SimpleBlog;

import org.SimpleBlog.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.SimpleBlog.service.ArticleService;

@Controller
public class ArticleController {
	
	private ArticleService articleService;

	@Autowired(required=true)
	@Qualifier(value= "ArticleService")
	public void setArticleService(ArticleService articleService){
		this.articleService = articleService;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String listArticles(Model model) {
		model.addAttribute("article", new Article());
		model.addAttribute("listArticles", this.articleService.listArticles());
		return "index";
	}
	
	//For add and update article both
	@RequestMapping(value= "/add", method = RequestMethod.POST)
	public String addArticle(@ModelAttribute("article") Article article){

        if(article.getId() == 0){
			//new article, add it
			this.articleService.addArticle(article);
		}else{
			//existing article, call update
			this.articleService.updateArticle(article);
		}

		
		return "redirect:/";
		
	}

	
	@RequestMapping("/remove/{id}")
    public String removeArticle(@PathVariable("id") int id){
		
        this.articleService.removeArticle(id);
        return "redirect:/";
    }
 
    @RequestMapping("/edit/{id}")
    public String editArticle(@PathVariable("id") int id, Model model){
        model.addAttribute("article", this.articleService.getArticleById(id));
        model.addAttribute("listArticles", this.articleService.listArticles());
        return "index";
    }

    @RequestMapping("/search/")
    public String searchArtByCat(@RequestParam ("search") String search, Model model){
        model.addAttribute("article", new Article());
	    model.addAttribute("filterList", this.articleService.searchArticles(search));
	    return "filter";
    }


	
}
