package com.qiusuo.techblogs.domain.repositories;

import com.qiusuo.techblogs.domain.models.BlogCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;


public interface BlogCategoryRepository extends JpaRepository<BlogCategory, String>, BlogCategoryRepositoryCustom, QuerydslPredicateExecutor<BlogCategory> {
}
