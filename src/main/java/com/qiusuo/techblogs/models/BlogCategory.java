package com.qiusuo.techblogs.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class BlogCategory {

    @Id
    @Column
    private String name;

    @OneToMany(mappedBy="blogCategory")
    private List<BlogItem> blogs;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BlogItem> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<BlogItem> blogs) {
        this.blogs = blogs;
    }
}
