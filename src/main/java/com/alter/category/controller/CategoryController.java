package com.alter.category.controller;

import com.alter.category.repository.CategoryRepository;
import com.alter.category.response.ResponseCategory;
import com.alter.category.response.ResponseSub;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequestMapping("/category")
@RestController
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryRepository categoryRepository;


    @GetMapping
    public List<ResponseCategory> getCategories () {
        return categoryRepository.findAll().stream().map(category -> {
            List<ResponseSub> subs = category.getSubs().stream().map(sub -> new ResponseSub(sub.getName(), sub.getUnique(), sub.getAvatar())).toList();
            return new ResponseCategory(category.getId(), subs);
        }).toList();
    }
}
