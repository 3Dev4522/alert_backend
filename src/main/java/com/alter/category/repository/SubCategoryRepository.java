package com.alter.category.repository;

import com.alter.category.entity.Category;
import com.alter.category.entity.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubCategoryRepository extends JpaRepository<SubCategory, String> {

    List<SubCategory> findAllByParent (Category parent);

}
