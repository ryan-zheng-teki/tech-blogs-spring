package com.qiusuo.techblogs.authentication.strategy;


import com.qiusuo.techblogs.authentication.config.CustomAuthenticationToken;
import com.qiusuo.techblogs.domain.models.user.QRole;
import com.qiusuo.techblogs.domain.models.user.QUser;
import com.qiusuo.techblogs.domain.models.user.Role;
import com.qiusuo.techblogs.domain.models.user.User;
import com.qiusuo.techblogs.domain.models.user.UserType;
import com.qiusuo.techblogs.domain.repositories.user.UserRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;

import java.util.ArrayList;

/*
What we will do is to use HttpClient to send one query request to github using the accessToken. If it returns
successful, then authentication sucess
 */
@Configuration
public class GithubAuthenticationStrategy {
    private static final Logger LOGGER = LoggerFactory.getLogger(GithubAuthenticationStrategy.class);
    @Autowired
    JPAQueryFactory jpaQueryFactory;

    @Autowired
    UserRepository userRepository;

    /*
     */
    public Authentication authenticate(CustomAuthenticationToken authentication) {
        LOGGER.debug("authenticate via github account");
        String accessToken = authentication.getAccessToken();
        /*
        TODO
        Step 1: Make a request to Github with the user and accessToken
        Step 2: If it succeeds, then persist the user and accessToken in database
        First check if the user already exist in DB. if it doesn't, then insert new user.
        If the user already exists in DB, then update the accessToken.
        If the accessToken is invalid, then we should throw one exception for BadCredential.
         */
        String username = authentication.getUsername();
        QUser user = QUser.user;
        User existingUser = jpaQueryFactory.selectFrom(user)
                .where(user.name.eq(username))
                .fetchOne();

        if (existingUser == null) {
            User newUser = new User();
            newUser.setEnabled(true);
            newUser.setName(username);
            newUser.setUserType(UserType.GITHUB);
            newUser.setEncryptedPassword(accessToken);
            newUser.setRoles(getRoles("ROLE_USER"));
            userRepository.save(newUser);
        } else {
            existingUser.setEncryptedPassword(accessToken);
            userRepository.save(existingUser);
        }
        return authentication;
    }

    private ArrayList<Role> getRoles(String roleName) {
        QRole role = QRole.role;
        Role roleUser = jpaQueryFactory.selectFrom(role).where(role.name.eq(roleName)).fetchOne();
        ArrayList<Role> roles = new ArrayList<Role>() {
            {
                add(roleUser);
            }
        };
        return roles;
    }
}
