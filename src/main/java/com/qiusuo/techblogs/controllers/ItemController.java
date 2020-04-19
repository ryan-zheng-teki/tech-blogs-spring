package com.qiusuo.techblogs.controllers;

import com.qiusuo.techblogs.models.Item;
import com.qiusuo.techblogs.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/")
    public List<Item> index() throws InterruptedException{
        return itemService.getItems();
    }
}
