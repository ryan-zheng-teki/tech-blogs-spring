package com.qiusuo.techblogs.domain.services;


import com.qiusuo.techblogs.domain.models.BlogItem;
import com.qiusuo.techblogs.domain.repositories.BlogCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogCategoryService {

    @Autowired
    private BlogCategoryRepository blogCategoryRepository;

    public List<BlogItem> getBlogs(String categoryId) {
        return blogCategoryRepository.findById(categoryId).get().getBlogs();
    }

}
