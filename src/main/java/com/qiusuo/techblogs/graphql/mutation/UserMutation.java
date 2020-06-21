package com.qiusuo.techblogs.graphql.mutation;

import com.qiusuo.techblogs.domain.models.user.User;
import com.qiusuo.techblogs.domain.services.user.UserService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Component;

@Secured("ROLE_ANONYMOUS")
@Component
public class UserMutation implements GraphQLMutationResolver {
    @Autowired
    UserService userService;

    public User registerUser(String name) {
        return userService.addUser(name);
    }
}