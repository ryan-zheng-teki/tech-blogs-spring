package com.qiusuo.techblogs.graphql;

import java.util.*;

public class BlogCategory {

    @javax.validation.constraints.NotNull
    private String id;
    @javax.validation.constraints.NotNull
    private String name;
    private Collection<BlogCategory> children;

    public BlogCategory() {
    }

    public BlogCategory(String id, String name, Collection<BlogCategory> children) {
        this.id = id;
        this.name = name;
        this.children = children;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Collection<BlogCategory> getChildren() {
        return children;
    }
    public void setChildren(Collection<BlogCategory> children) {
        this.children = children;
    }



    public static class Builder {

        private String id;
        private String name;
        private Collection<BlogCategory> children;

        public Builder() {
        }

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setChildren(Collection<BlogCategory> children) {
            this.children = children;
            return this;
        }


        public BlogCategory build() {
            return new BlogCategory(id, name, children);
        }

    }
}
