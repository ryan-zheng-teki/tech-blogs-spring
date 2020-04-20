package com.qiusuo.techblogs.graphql;

import java.util.*;

public interface Query {

    @javax.validation.constraints.NotNull
    Collection<BlogCategory> allCategories() throws Exception;

}