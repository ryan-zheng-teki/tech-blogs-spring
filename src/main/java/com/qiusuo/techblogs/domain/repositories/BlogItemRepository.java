package com.qiusuo.techblogs.domain.repositories;

import com.qiusuo.techblogs.domain.models.BlogItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogItemRepository extends JpaRepository<BlogItem, String>, QuerydslPredicateExecutor<BlogItem> {
}
