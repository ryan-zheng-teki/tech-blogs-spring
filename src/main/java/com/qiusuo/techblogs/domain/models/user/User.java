package com.qiusuo.techblogs.domain.models.user;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class User {
    @Id
    private String id;

    @Column(unique =true)
    private String name;
}
