package com.qiusuo.techblogs.graphql.mutation;

import com.qiusuo.techblogs.domain.models.blog.BlogItem;
import com.qiusuo.techblogs.domain.services.blog.BlogService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.AllArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Secured("ROLE_USER")
@Component
public class BlogMutation implements GraphQLMutationResolver {
    BlogService blogService;

    public BlogItem createBlog(String categoryId, String blogContent) {
        return blogService.createBlog(categoryId, blogContent);
    }
}
