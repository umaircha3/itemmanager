package com.fearless.itemmanager.controller;

import com.fearless.itemmanager.model.Item;
import com.fearless.itemmanager.model.ItemRequest;
import com.fearless.itemmanager.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping()
public class ItemsController {

    @Autowired
    ItemsService itemsService;

    @PostMapping("/items")
    public Item createItem(@RequestBody ItemRequest itemRequest){
        return itemsService.createItem(itemRequest);
    }

    @GetMapping("/items")
    public List<Item> getAllItems(){
        return itemsService.getAllItems();
    }

}
