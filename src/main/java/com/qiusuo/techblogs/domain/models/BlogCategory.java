package com.qiusuo.techblogs.domain.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;


@Data
@Entity
public class BlogCategory {
    @Id
    private String name;

    @ManyToOne
    @JoinColumn(name = "parentCategory")
    private BlogCategory parentCategory;

    private int sequenceNumber;

    @OneToMany(mappedBy = "blogCategory")
    private List<BlogItem> blogs;

    @OneToMany(mappedBy = "parentCategory")
    private List<BlogCategory> subCategories;
}
