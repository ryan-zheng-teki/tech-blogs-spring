package com.qiusuo.techblogs.domain.repositories;


import com.qiusuo.techblogs.domain.models.BlogCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogCategoryRepository  extends CrudRepository<BlogCategory, String> {

}
