package com.qiusuo.techblogs.domain.repositories.impl;

import com.qiusuo.techblogs.domain.models.BlogCategory;
import com.qiusuo.techblogs.domain.models.QBlogCategory;
import com.qiusuo.techblogs.domain.repositories.BlogCategoryRepositoryCustom;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Transactional
public class BlogCategoryRepositoryCustomImpl implements BlogCategoryRepositoryCustom {
    @Autowired
    private JPAQueryFactory queryFactory;

    @Override
    public Collection<BlogCategory> getTopLevelCategories() {
        QBlogCategory blogCategory = new QBlogCategory("parent");

        Collection<BlogCategory> topCategories = queryFactory
                .selectFrom(blogCategory)
                .innerJoin(blogCategory.subCategories)
                .fetchJoin()
                .orderBy(blogCategory.sequenceNumber.asc())
                .distinct()
                .fetch();

        return topCategories;
    }

}
