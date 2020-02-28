package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Article;

/**
 * 記事テーブルを操作するレポジトリ.
 * 
 * @author tsuchiyahiromu
 *
 */
@Repository
public class ArticleRepository {
	@Autowired
	private NamedParameterJdbcTemplate template;

	private static final RowMapper<Article> ARTICLE_ROW_MAPPER_ = (rs, i) -> {
		Article article = new Article();
		article.setId(rs.getInt("id"));
		article.setName(rs.getString("name"));
		article.setContent(rs.getString("content"));
		return article;
	};

	/**
	 * 全件検索るメソッド.
	 * 
	 * @return 記事一覧を返す
	 */
	public List<Article> findAll() {
		String sql = "SELECT id,name,content FROM articles ORDER BY id desc";
		List<Article> articleList = template.query(sql, ARTICLE_ROW_MAPPER_);
		return articleList;
	}

	/**
	 * 新たに記事を投稿するメソッド.
	 * 
	 * @param article 投稿する情報の入った記事オブジェクト
	 */
	public void insert(Article article) {
		String sql = "INSERT INTO articles (name,content) VALUES(:name,:content)";
		SqlParameterSource param = new BeanPropertySqlParameterSource(article);
		template.update(sql, param);

	}

	/**
	 * 既存の記事を消去するメソッド.
	 * 
	 * @param Id 削除したい記事id
	 */
	public void deleteById(int id) {
		String sql = "DELETE FROM articles WHERE id = :id";
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		template.update(sql, param);
	}
}
