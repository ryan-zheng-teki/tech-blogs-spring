package com.qiusuo.techblogs.domain.repositories.blog;

import com.qiusuo.techblogs.domain.models.blog.BlogItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

/*
There is no need to add Repository annotation. Because JPA will automatically
check the interfaces that extends Repository and create a repo bean based on
the implementation
 */
public interface BlogItemRepository extends JpaRepository<BlogItem, String>, QuerydslPredicateExecutor<BlogItem> {
}
