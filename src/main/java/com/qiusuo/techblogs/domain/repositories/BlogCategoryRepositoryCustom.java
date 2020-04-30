package com.qiusuo.techblogs.domain.repositories;


import com.qiusuo.techblogs.domain.models.BlogCategory;
import com.qiusuo.techblogs.domain.models.BlogItem;

import java.util.Collection;


public interface BlogCategoryRepositoryCustom {
    Collection<BlogCategory> getTopLevelCategories();

    Collection<BlogItem> getBlogsForCategory(String categoryId);
}
