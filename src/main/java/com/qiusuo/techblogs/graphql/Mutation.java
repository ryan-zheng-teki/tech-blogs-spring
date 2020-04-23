package com.qiusuo.techblogs.graphql;

import com.qiusuo.techblogs.domain.models.BlogItem;
import com.qiusuo.techblogs.domain.services.BlogService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.charset.Charset;

@Component
public class Mutation implements GraphQLMutationResolver {
    @Autowired
    BlogService blogService;

    public BlogItem createBlog(String categoryId, String blogContent) {
        return blogService.saveBlog(categoryId, blogContent.getBytes(Charset.forName("UTF-8")));
    }

}
