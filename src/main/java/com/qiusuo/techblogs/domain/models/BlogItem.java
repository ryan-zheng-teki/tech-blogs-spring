package com.qiusuo.techblogs.domain.models;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Data
@Entity
public class BlogItem {
    @Id
    private int sequenceNumber;

    private String title;

    private String summary;

    private String hyperTextContent;
    
    private LocalDate creationDate;

    private LocalDate modificationDate;

    @ManyToOne
    @JoinColumn(name = "blogcategory_fk")
    private BlogCategory blogCategory;
}
