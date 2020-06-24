package com.qiusuo.techblogs.graphql.query;

import com.qiusuo.techblogs.domain.models.user.User;
import com.qiusuo.techblogs.domain.services.user.UserService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.AllArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Secured("ROLE_USER")
@Component
public class UserQuery implements GraphQLQueryResolver {
    UserService userService;

    //We could actually get the user details information from the JWT token
    public User userDetails() {
        return userService.getCurrentUser();
    }
}
