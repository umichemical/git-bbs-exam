package com.example.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Article;
import com.example.form.ArticleForm;
import com.example.repository.ArticleRepository;

@Controller
@RequestMapping("/bbs")
public class InsertArticleController {
	@Autowired
	private ArticleRepository articleRepository;

	@RequestMapping("/insertArticle")
	public String insertArticle(ArticleForm articleForm) {
		Article article = new Article();
		BeanUtils.copyProperties(articleForm, article);
		articleRepository.insert(article);
		return "redirect:/article/output";
	}

	@RequestMapping("/output")
	public String output(Model model) {
		return index(model);
	}
}
