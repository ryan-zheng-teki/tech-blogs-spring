package com.qiusuo.techblogs.domain.models.blog;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
@Entity
public class BlogCategory {
    @Id
    private String name;

    @ManyToOne
    @JoinColumn(name = "parentCategory")
    private BlogCategory parentCategory;

    @Column(unique = true)
    private int sequenceNumber;

    @OneToMany(mappedBy = "blogCategory")
    private List<BlogItem> blogs;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "parentCategory")
    private List<BlogCategory> subCategories;
}
