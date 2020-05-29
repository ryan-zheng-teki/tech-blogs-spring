package com.qiusuo.techblogs.graphql;

import com.qiusuo.techblogs.domain.models.blog.BlogItem;
import com.qiusuo.techblogs.domain.models.user.User;
import com.qiusuo.techblogs.domain.services.blog.BlogService;
import com.qiusuo.techblogs.domain.services.user.UserService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Component;

@Component
public class Mutation implements GraphQLMutationResolver {
    @Autowired
    BlogService blogService;

    @Autowired
    UserService userService;

    @Secured("ROLE_USER")
    public BlogItem createBlog(String categoryId, String blogContent) {
        return blogService.createBlog(categoryId, blogContent);
    }

    public User addUser(String name) {
        return userService.addUser(name);
    }
}
