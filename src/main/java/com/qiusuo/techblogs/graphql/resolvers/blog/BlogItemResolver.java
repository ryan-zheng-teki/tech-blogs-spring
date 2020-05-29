package com.qiusuo.techblogs.graphql.resolvers.blog;

import com.qiusuo.techblogs.domain.models.blog.BlogItem;
import graphql.kickstart.tools.GraphQLResolver;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

@Component
public class BlogItemResolver implements GraphQLResolver<BlogItem> {

    public String getContent(BlogItem blog) {
        return new String(blog.getContent(), StandardCharsets.UTF_8);
    }
}
