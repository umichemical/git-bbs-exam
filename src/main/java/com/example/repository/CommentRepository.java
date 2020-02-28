package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Comment;

/**
 * コメント機能で使用するリポジトリ.
 * 
 * @author tanaami
 *
 */
@Repository
public class CommentRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;

	private static final RowMapper<Comment> COMMENT_ROW_MAPPER = (rs, i) -> {
		Comment comment = new Comment();
		comment.setId(rs.getInt("id"));
		comment.setName(rs.getString("name"));
		comment.setContent(rs.getString("content"));
		comment.setArticleId(rs.getInt("article_id"));

		return comment;
	};

	/**
	 * 記事IDに紐づいたコメントを表示するメソッド.
	 * 
	 * @param articleId 記事ID
	 * @return コメントを表示
	 */
	public List<Comment> findByArticleID(int articleId) {
		String sql = "SELECT id, name, content, article_id FROM comments WHERE article_id = :articleId ORDER BY id";
		SqlParameterSource param = new MapSqlParameterSource().addValue("articleId", articleId);
		List<Comment> commentList = template.query(sql, param, COMMENT_ROW_MAPPER);
		return commentList;
	}

	/**
	 * コメント投稿するメソッド.
	 * 
	 * @param comment 投稿したコメント
	 */
	public void insert(Comment comment) {
		String sql = "INSERT INTO  comments (name, content, article_id) VALUES (:name, :content, :articleId)";
		SqlParameterSource param = new BeanPropertySqlParameterSource(comment);
		template.update(sql, param);
	}

	/**
	 * 記事と該当記事に関連したコメントを削除するメール.
	 * 
	 * @param articleId 記事ID
	 */
	public void deleteByArticleID(int articleId) {
		String sql = "DELETE FROM comments WHERE article_id = :articleId;";
		SqlParameterSource param = new MapSqlParameterSource().addValue("articleId", articleId);
		template.update(sql, param);
	}

}
