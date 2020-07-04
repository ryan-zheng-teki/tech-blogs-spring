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
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;

/*
What we will do is to use HttpClient to send one query request to github using the accessToken. If it returns
successful, then authentication sucess
 */
@Configuration
public class GithubAuthenticationStrategy {
    private static final Logger LOGGER = LoggerFactory.getLogger(GithubAuthenticationStrategy.class);

    UserRepository userRepository;
    JPAQueryFactory jpaQueryFactory;

    public GithubAuthenticationStrategy(JPAQueryFactory jpaQueryFactory,UserRepository userRepository) {
        this.userRepository = userRepository;
        this.jpaQueryFactory = jpaQueryFactory;
    }

    /*
     */
    public Authentication authenticate(CustomAuthenticationToken authentication) {
        LOGGER.debug("authenticate via github account");
        String username = authentication.getUsername();
        QUser user = QUser.user;

        try {
            User existingUser = userRepository.getUserByName(username);
        } catch(UsernameNotFoundException e) {
            User newUser = new User();
            newUser.setEnabled(true);
            newUser.setName(username);
            newUser.setUserType(UserType.GITHUB);
            newUser.setUserId(authentication.getUserId());
            newUser.setAvatarUrl(authentication.getAvatarUrl());
            /*We set the password because when building user in JwtUserService
            Password is one mandatory field
             */
            newUser.setEncryptedPassword(authentication.getUserId());
            newUser.setRoles(getRoles("USER"));
            userRepository.save(newUser);
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
