package com.example.form;

/**
 * 投稿情報を受け取るフォーム.
 * 
 * @author yuri.okada
 *
 */
public class ArticleForm {

	/** 投稿氏名 */
	private String name;

	/** 投稿内容 */
	private String content;

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

	@Override
	public String toString() {
		return "ArticleForm [name=" + name + ", content=" + content + "]";
	}

}

