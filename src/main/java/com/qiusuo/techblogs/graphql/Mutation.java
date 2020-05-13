package com.qiusuo.techblogs.graphql;

import com.qiusuo.techblogs.domain.models.blog.BlogItem;
import com.qiusuo.techblogs.domain.models.user.User;
import com.qiusuo.techblogs.domain.services.blog.BlogService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mutation implements GraphQLMutationResolver {
    @Autowired
    BlogService blogService;

    public BlogItem createBlog(String categoryId, String blogContent) {
        return blogService.saveBlog(categoryId, blogContent);
    }

    public User addUser(String id) {
        return new User();
    }
}
