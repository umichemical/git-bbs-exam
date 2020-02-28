package com.example.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Comment;
import com.example.form.CommentForm;
import com.example.repository.CommentRepository;

@Controller
@RequestMapping("/bbs")
public class insertCommentController {

	@Autowired
	private CommentRepository commentRepository;
	
	@ModelAttribute
	public CommentForm setUpCommentForm() {
		return new CommentForm();
	}
	
	/**
	 * コメント情報を挿入する.
	 * 
	 * @param commentForm コメント情報のフォーム
	 * @return 掲示板画面へリダイレクト
	 */
	@RequestMapping("/insert-comment")
	public String insertComment(CommentForm commentForm) {
		Comment comment = new Comment();
		BeanUtils.copyProperties(commentForm, comment);

		comment.setArticleId(commentForm.getIntArticleId());
		commentRepository.insert(comment);

		return "redirect:/bbs";

	}
}
