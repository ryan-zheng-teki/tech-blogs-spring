package com.qiusuo.techblogs.domain.repositories.user.impl;

import com.qiusuo.techblogs.domain.models.user.QUser;
import com.qiusuo.techblogs.domain.models.user.User;
import com.qiusuo.techblogs.domain.repositories.user.UserRepositoryCustom;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@AllArgsConstructor
public class UserRepositoryCustomImpl implements UserRepositoryCustom {
    private JPAQueryFactory jpaQueryFactory;

    @Override
    public User getUserByName(String name) {
        QUser user = QUser.user;
        User existingUser = jpaQueryFactory.selectFrom(user)
                .where(user.name.eq(name))
                .fetchOne();
        if(existingUser == null) {
            throw new UsernameNotFoundException("username with name not found");
        }
        return existingUser;
    }
}
