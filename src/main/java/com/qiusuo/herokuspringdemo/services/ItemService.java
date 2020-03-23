package com.qiusuo.herokuspringdemo.services;


import com.qiusuo.herokuspringdemo.models.Item;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService {
    public List<Item> getItems() {
        List<Item> items = new ArrayList<>();
        items.add( new Item("item1", "description1"));
        items.add( new Item("item2", "description2"));
        return items;
    }
}
