package com.qiusuo.techblogs.authentication.config;

import com.qiusuo.core.authenticationservice.model.QUser;
import com.qiusuo.core.authenticationservice.model.Role;
import com.qiusuo.core.authenticationservice.model.User;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
    JPAQueryFactory jpaQueryFactory;

    @Autowired
    PasswordEncoder passwordEncoder;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        QUser userToQuery = QUser.user;
        User userResult = jpaQueryFactory.selectFrom(userToQuery).where(userToQuery.name.eq(username)).fetchOne();

        org.springframework.security.core.userdetails.User.UserBuilder builder;
        if (userResult != null) {
            builder = org.springframework.security.core.userdetails.User.withUsername(username);
            builder.password(userResult.getEncryptedPassword());
            builder.roles(userResult.getRoles().stream().map(Role::getName).toString());
        } else {
            throw new UsernameNotFoundException("User not found.");
        }

        return builder.build();
    }
    
}
