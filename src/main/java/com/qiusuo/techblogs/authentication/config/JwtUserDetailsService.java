package com.qiusuo.techblogs.authentication.config;


import com.qiusuo.techblogs.domain.models.user.QUser;
import com.qiusuo.techblogs.domain.models.user.Role;
import com.qiusuo.techblogs.domain.models.user.User;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
public class JwtUserDetailsService implements UserDetailsService {
    private JPAQueryFactory jpaQueryFactory;

    public JwtUserDetailsService(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        QUser userToQuery = QUser.user;
        User userResult = jpaQueryFactory.selectFrom(userToQuery).where(userToQuery.name.eq(username)).fetchOne();

        org.springframework.security.core.userdetails.User.UserBuilder builder;
        if (userResult != null) {
            builder = org.springframework.security.core.userdetails.User.withUsername(username);
            builder.password(userResult.getEncryptedPassword());
            String roleName = userResult.getRoles().stream().map(Role::getName).collect(Collectors.joining(","));
            builder.roles(roleName).username(userResult.getName()).password(userResult.getEncryptedPassword());
        } else {
            throw new UsernameNotFoundException("User not found.");
        }
        return builder.build();
    }

}
