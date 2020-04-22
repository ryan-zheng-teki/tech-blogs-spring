package com.qiusuo.techblogs.domain.repositories;


import com.qiusuo.techblogs.domain.models.BlogCategory;

import java.util.Collection;


public interface BlogCategoryRepositoryCustom {
    Collection<BlogCategory> getTopLevelCategories();
}
