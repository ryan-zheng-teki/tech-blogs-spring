package com.qiusuo.techblogs.graphql;

import com.qiusuo.techblogs.domain.models.BlogCategory;
import com.qiusuo.techblogs.domain.models.BlogItem;
import com.qiusuo.techblogs.domain.services.BlogService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class Query implements GraphQLQueryResolver {

    @Autowired
    BlogService blogService;

    public Collection<BlogCategory> categories() {
        return blogService.getAllCategories();
    }

    public Collection<BlogItem> latestBlogs(int latest) {
        return blogService.getLatestedBlogs(latest);
    }

    public Collection<BlogItem> blogsForCategory(String categoryId) {
        return blogService.getBlogsForCategory(categoryId);
    }


}