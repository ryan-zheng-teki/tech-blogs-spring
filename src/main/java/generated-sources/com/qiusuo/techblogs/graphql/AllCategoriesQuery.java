package com.qiusuo.techblogs.graphql;

import java.util.*;

public interface AllCategoriesQuery {

    @javax.validation.constraints.NotNull
    Collection<BlogCategory> allCategories() throws Exception;

}