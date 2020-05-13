package com.qiusuo.techblogs.domain.repositories.blog;

import com.qiusuo.techblogs.domain.models.blog.BlogCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;


public interface BlogCategoryRepository extends JpaRepository<BlogCategory, String>, BlogCategoryRepositoryCustom, QuerydslPredicateExecutor<BlogCategory> {
}
