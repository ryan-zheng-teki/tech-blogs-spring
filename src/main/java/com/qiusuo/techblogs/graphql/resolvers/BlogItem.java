package com.qiusuo.techblogs.graphql.resolvers;

public class BlogItem {

    @javax.validation.constraints.NotNull
    private String id;
    @javax.validation.constraints.NotNull
    private String summary;
    @javax.validation.constraints.NotNull
    private String hyperTextContent;

    public BlogItem() {
    }

    public BlogItem(String id, String summary, String hyperTextContent) {
        this.id = id;
        this.summary = summary;
        this.hyperTextContent = hyperTextContent;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getSummary() {
        return summary;
    }
    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getHyperTextContent() {
        return hyperTextContent;
    }
    public void setHyperTextContent(String hyperTextContent) {
        this.hyperTextContent = hyperTextContent;
    }



    public static class Builder {

        private String id;
        private String summary;
        private String hyperTextContent;

        public Builder() {
        }

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setSummary(String summary) {
            this.summary = summary;
            return this;
        }

        public Builder setHyperTextContent(String hyperTextContent) {
            this.hyperTextContent = hyperTextContent;
            return this;
        }


        public BlogItem build() {
            return new BlogItem(id, summary, hyperTextContent);
        }

    }
}
