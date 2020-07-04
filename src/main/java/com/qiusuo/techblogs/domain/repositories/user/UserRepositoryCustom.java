package com.qiusuo.techblogs.domain.repositories.user;

import com.qiusuo.techblogs.domain.models.user.User;

public interface UserRepositoryCustom {
    User getUserByName(String name);
}
