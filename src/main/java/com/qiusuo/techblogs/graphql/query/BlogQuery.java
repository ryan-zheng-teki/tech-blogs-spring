package com.qiusuo.techblogs.graphql.query;

import com.qiusuo.techblogs.domain.models.blog.BlogCategory;
import com.qiusuo.techblogs.domain.models.blog.BlogItem;
import com.qiusuo.techblogs.domain.services.blog.BlogService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.relay.Connection;
import graphql.relay.SimpleListConnection;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class BlogQuery implements GraphQLQueryResolver {
    @Autowired
    BlogService blogService;

    public Collection<BlogCategory> categories() {
        return blogService.getAllCategories();
    }

    public Connection<BlogItem> blogs(int first, String after, DataFetchingEnvironment env) {
        return new SimpleListConnection<>(blogService.getLatestedBlogs(first)).get(env);
    }

    public Collection<BlogItem> blogsForCategory(String categoryId) {
        return blogService.getBlogsForCategory(categoryId);
    }

}