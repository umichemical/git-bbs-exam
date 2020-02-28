package com.example.domain;

/**
 * 投稿コメントのドメイン
 * @author yuri.okada
 *
 */
public class Comment {
	
	/** ID */
	private Integer id;

	/** コメント者名 */
	private String name;

	/** コメント内容 */
	private String content;

	/** 投稿ID */
	private Integer articleId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getArticleId() {
		return articleId;
	}

	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", name=" + name + ", content=" + content + ", articleId=" + articleId + "]";
	}


}
