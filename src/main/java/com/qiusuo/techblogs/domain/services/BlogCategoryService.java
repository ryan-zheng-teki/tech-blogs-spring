package com.qiusuo.techblogs.domain.services;


import com.qiusuo.techblogs.domain.models.BlogCategory;
import com.qiusuo.techblogs.domain.models.BlogItem;
import com.qiusuo.techblogs.domain.repositories.BlogCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class BlogCategoryService {

    @Autowired
    private BlogCategoryRepository blogCategoryRepository;

    @PersistenceContext
    private EntityManager em;

    public List<BlogItem> getBlogs(String categoryId) {
        return blogCategoryRepository.findById(categoryId).get().getBlogs();
    }


    public List<BlogCategory> getAllCategories() {
        Iterable<BlogCategory> iterable = blogCategoryRepository.findAll();
        return StreamSupport.stream(iterable.spliterator(), false).collect(Collectors.toList());
    }

    @PostConstruct
    public void fooInit() {
        System.out.println("foot finished init");
    }

}
