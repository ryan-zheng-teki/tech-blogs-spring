package com.qiusuo.techblogs.graphql.resolvers.blog;

import com.qiusuo.techblogs.domain.models.blog.BlogCategory;
import graphql.kickstart.tools.GraphQLResolver;
import org.springframework.stereotype.Component;

@Component
public class BlogCategoryResolver implements GraphQLResolver<BlogCategory> {

    public String getId(BlogCategory blogCategory) {
        return blogCategory.getName();
    }
}
