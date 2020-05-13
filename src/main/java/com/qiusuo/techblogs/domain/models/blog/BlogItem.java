package com.qiusuo.techblogs.domain.models.blog;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Data
@Entity
public class BlogItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private long id;

    private String title;

    private String summary;

    private byte[] content;

    private LocalDate creationDate;

    private LocalDate modificationDate;

    @ManyToOne
    @JoinColumn(name = "blogcategory_fk")
    private BlogCategory blogCategory;
}
