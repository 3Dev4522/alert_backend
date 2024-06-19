package com.alter.article.controller;

import com.alter.article.repository.ArticleRepository;
import com.alter.article.response.ResponseArticle;
import com.alter.category.entity.SubCategory;
import com.alter.category.repository.SubCategoryRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/article")
public class ArticleController {

    private final ArticleRepository     articleRepository;
    private final SubCategoryRepository subCategoryRepository;

    private final ObjectMapper objectMapper;


    // 본문 데이터를 일정크기로 짤라서 보내도록 수정해야함.
    @GetMapping("/{subCategory}")
    public List<ResponseArticle> getArticles (@PathVariable("subCategory") final String subCategory) {
        SubCategory findSubCategory = subCategoryRepository.findById(subCategory).orElseThrow();
        return articleRepository.findAllBySubCategory(findSubCategory).stream().map(result -> {
            ResponseArticle article = objectMapper.convertValue(result.getAi(), ResponseArticle.class);
            return new ResponseArticle(article.title(), article.content(), result.getCreated());
        }).toList();
    }

    @GetMapping("/{subCategory}/{articleId}")
    public ResponseArticle getArticleDetail (@PathVariable("subCategory") final String subCategory,
                                             @PathVariable("articleId")   final Long articleId) {
        return null;
    }
}
