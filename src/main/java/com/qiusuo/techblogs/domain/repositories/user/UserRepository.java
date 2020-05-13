package com.qiusuo.techblogs.domain.repositories.user;

import com.qiusuo.techblogs.domain.models.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
}
