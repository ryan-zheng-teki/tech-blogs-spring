package com.qiusuo.techblogs.domain.repositories.impl;

import com.qiusuo.techblogs.domain.models.BlogCategory;
import com.qiusuo.techblogs.domain.models.QBlogCategory;
import com.qiusuo.techblogs.domain.repositories.BlogCategoryRepositoryCustom;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

public class BlogCategoryRepositoryCustomImpl implements BlogCategoryRepositoryCustom {
    @PersistenceContext
    private EntityManager em;

    @Autowired
    private JPAQueryFactory queryFactory;

    @Override
    public Collection<BlogCategory> getTopLevelCategories() {
        QBlogCategory blogCategory = QBlogCategory.blogCategory;
        Collection<BlogCategory> topCategories = queryFactory.selectFrom(blogCategory).where(blogCategory.parentCategory.isNotNull()).fetch();
        return topCategories;
    }

    @PostConstruct
    public void fooInit() {
        System.out.println("foot finished init");
    }

}
