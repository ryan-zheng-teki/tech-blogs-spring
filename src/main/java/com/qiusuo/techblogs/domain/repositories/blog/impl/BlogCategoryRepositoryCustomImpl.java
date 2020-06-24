package com.qiusuo.techblogs.domain.repositories.blog.impl;

import com.qiusuo.techblogs.domain.models.blog.BlogCategory;
import com.qiusuo.techblogs.domain.models.blog.BlogItem;
import com.qiusuo.techblogs.domain.models.blog.QBlogCategory;
import com.qiusuo.techblogs.domain.models.blog.QBlogItem;
import com.qiusuo.techblogs.domain.repositories.blog.BlogCategoryRepositoryCustom;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Getter
@Setter
public class BlogCategoryRepositoryCustomImpl implements BlogCategoryRepositoryCustom {

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


    @Override
    public Collection<BlogItem> getBlogsForCategory(String categoryId) {
        QBlogItem blogItem = QBlogItem.blogItem;
        Collection<BlogItem> blogs = queryFactory.selectFrom(blogItem)
                .orderBy(blogItem.creationDate.asc())
                .where(blogItem.blogCategory.name.eq(categoryId))
                .fetch();
        return blogs;
    }


}
