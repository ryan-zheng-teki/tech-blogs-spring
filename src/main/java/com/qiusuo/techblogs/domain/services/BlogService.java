package com.qiusuo.techblogs.domain.services;


import com.qiusuo.techblogs.domain.models.BlogCategory;
import com.qiusuo.techblogs.domain.models.BlogItem;
import com.qiusuo.techblogs.domain.repositories.BlogCategoryRepository;
import com.qiusuo.techblogs.domain.repositories.BlogItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Transactional
@Service
public class BlogService {

    @Autowired
    private BlogCategoryRepository blogCategoryRepository;

    @Autowired
    private BlogItemRepository blogItemRepository;

    public Collection<BlogItem> getBlogsForCategory(String categoryId) {
        return blogCategoryRepository.getBlogsForCategory(categoryId);
    }


    public Collection<BlogCategory> getAllCategories() {
        return blogCategoryRepository.getTopLevelCategories();
    }

    public Collection<BlogItem> getLatestedBlogs(int latest) {
        Pageable sortedByCeationDt = PageRequest.of(0, latest, Sort.by(Sort.Direction.ASC, "creationDate"));
        return blogItemRepository.findAll(sortedByCeationDt).getContent();
    }

    public BlogItem saveBlog(String categoryId, String blogContent) {
        BlogItem blogItem = new BlogItem();

        BlogCategory parentCategory = new BlogCategory();
        parentCategory.setName(categoryId);
        blogItem.setContent(blogContent.getBytes());
        blogItem.setBlogCategory(parentCategory);
        blogItemRepository.save(blogItem);
        return blogItem;
    }
}
