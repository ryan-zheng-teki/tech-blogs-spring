package com.qiusuo.techblogs.graphql;

import com.qiusuo.techblogs.domain.models.BlogCategory;
import com.qiusuo.techblogs.domain.services.BlogCategoryService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class Query implements GraphQLQueryResolver {

    @Autowired
    BlogCategoryService blogCategoryService;

    public Collection<BlogCategory> allCategories() {
        List<BlogCategory> categories = new ArrayList<BlogCategory>();

        BlogCategory blogCategory = new BlogCategory();
        blogCategory.setName("test");
        categories.add(blogCategory);
        return categories;
    }
}