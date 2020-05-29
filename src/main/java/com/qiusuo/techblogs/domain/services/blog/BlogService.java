package com.qiusuo.techblogs.domain.services.blog;


import com.qiusuo.techblogs.domain.models.blog.BlogCategory;
import com.qiusuo.techblogs.domain.models.blog.BlogItem;
import com.qiusuo.techblogs.domain.repositories.blog.BlogCategoryRepository;
import com.qiusuo.techblogs.domain.repositories.blog.BlogItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.Collection;
import java.util.List;

@Transactional
@Service
public class BlogService {
    @Autowired
    private EntityManager em;

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

    public List<BlogItem> getLatestedBlogs(int latest) {
        Pageable sortedByCeationDt = PageRequest.of(0, latest, Sort.by(Sort.Direction.ASC, "creationDate"));
        return blogItemRepository.findAll(sortedByCeationDt).getContent();
    }


    public BlogItem createBlog(String categoryId, String blogContent) {
        BlogItem blogItem = new BlogItem();

        BlogCategory parentCategory = em.getReference(BlogCategory.class, categoryId);
        blogItem.setContent(blogContent.getBytes());
        blogItem.setBlogCategory(parentCategory);
        blogItemRepository.save(blogItem);
        return blogItem;
    }
}
