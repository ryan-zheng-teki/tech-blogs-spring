package com.qiusuo.techblogs.authentication.config;


import com.qiusuo.techblogs.domain.models.user.QUser;
import com.qiusuo.techblogs.domain.models.user.Role;
import com.qiusuo.techblogs.domain.models.user.User;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {
    private JPAQueryFactory jpaQueryFactory;
    private PasswordEncoder passwordEncoder;

    public JwtUserDetailsService(JPAQueryFactory jpaQueryFactory, PasswordEncoder passwordEncoder) {
        this.jpaQueryFactory = jpaQueryFactory;
        this.passwordEncoder = passwordEncoder;
    }

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
