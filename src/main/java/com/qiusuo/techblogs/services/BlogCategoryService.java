package com.qiusuo.techblogs.services;


import com.qiusuo.techblogs.models.BlogCategory;
import com.qiusuo.techblogs.models.BlogItem;
import com.qiusuo.techblogs.repositories.BlogCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogCategoryService {

    @Autowired
    private BlogCategoryRepository blogCategoryRepository;

    public List<BlogItem> getBlogs(String categoryId) {
        return blogCategoryRepository.findById(categoryId).get().getBlogs();
    }
}
