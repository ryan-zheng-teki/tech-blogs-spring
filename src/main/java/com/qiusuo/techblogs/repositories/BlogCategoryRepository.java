package com.qiusuo.techblogs.repositories;


import com.qiusuo.techblogs.models.BlogCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogCategoryRepository  extends CrudRepository<BlogCategory, String> {

}
