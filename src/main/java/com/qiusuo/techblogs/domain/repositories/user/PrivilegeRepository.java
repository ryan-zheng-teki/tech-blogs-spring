package com.qiusuo.techblogs.domain.repositories.user;

import com.qiusuo.techblogs.domain.models.user.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrivilegeRepository extends JpaRepository<Privilege, Long> {
}
