package com.qiusuo.techblogs.domain.repositories.user;

import com.qiusuo.techblogs.domain.models.user.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, String> {
}
