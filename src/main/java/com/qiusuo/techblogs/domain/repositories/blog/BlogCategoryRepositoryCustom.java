package com.qiusuo.techblogs.domain.repositories.blog;


import com.qiusuo.techblogs.domain.models.blog.BlogCategory;
import com.qiusuo.techblogs.domain.models.blog.BlogItem;

import java.util.Collection;


public interface BlogCategoryRepositoryCustom {
    Collection<BlogCategory> getTopLevelCategories();

    Collection<BlogItem> getBlogsForCategory(String categoryId);
}
