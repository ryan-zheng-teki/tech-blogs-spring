package com.qiusuo.techblogs.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BlogItem {

    @Id
    private int sequenceNumber;

    @Column
    private String title;

    @Column
    private String summary;

    @Column
    private String hyperTextContent;


    public int getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(int sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
}
