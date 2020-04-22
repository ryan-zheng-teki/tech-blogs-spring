package com.qiusuo.techblogs.domain.repositories;

import com.qiusuo.techblogs.domain.models.BlogCategory;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BlogCategoryRepository extends JpaRepository<BlogCategory, String>, BlogCategoryRepositoryCustom {
}
