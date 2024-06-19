package com.alter.article.repository;

import com.alter.article.entity.Article;
import com.alter.category.entity.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {

    List<Article> findAllBySubCategory (final SubCategory subCategory);

}
