package com.example.form;

	/**
	 * コメント情報を受け取るフォーム.
	 * 
	 * @author yuri.okada
	 *
	 */
	public class CommentForm {

		/** 投稿ID */
		private String articleId;

		/** コメント氏名 */
		private String name;

		/** コメント内容 */
		private String content;



		public String getArticleId() {
			return articleId;
		}

		public Integer getIntArticleId() {
			Integer articleId=Integer.parseInt(this.articleId);
			return articleId;
		}


		public void setArticleId(String articleId) {
			this.articleId = articleId;
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



		@Override
		public String toString() {
			return "CommentForm [articleId=" + articleId + ", name=" + name + ", content=" + content + "]";
		}

	}
