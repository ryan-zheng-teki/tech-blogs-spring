package com.qiusuo.techblogs.graphql.resolvers;

import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class Query implements GraphQLQueryResolver {

    public Collection<BlogCategory> allCategories() {
        return new ArrayList<>();
    }
}