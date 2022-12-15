package com.fearless.itemmanager.controller;

import com.fearless.itemmanager.model.Item;
import com.fearless.itemmanager.model.ItemRequest;
import com.fearless.itemmanager.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class ItemsController {

    @Autowired
    ItemsService itemsService;

    @PostMapping("/items")
    public Item createItem(@RequestBody ItemRequest itemRequest) {
        return itemsService.createItem(itemRequest);
    }

    @GetMapping("/items")
    public List<Item> getAllItems() {
        return itemsService.getAllItems();
    }

    @GetMapping("/items/{id}")
    public Item getItemById(@PathVariable(value = "id") Long id) {
        return itemsService.getItemById(id);
    }

    @PutMapping("/items/{id}")
    public Item updateItemById(@PathVariable(value = "id") Long id, @RequestBody ItemRequest itemRequest) {
        return itemsService.updateItemById(id, itemRequest);
    }

    @DeleteMapping("/items")
    public void deleteAllItems() {
        itemsService.deleteAllItems();
    }

    @DeleteMapping("/items/{id}")
    public void deleteById(@PathVariable(value = "id") Long id) {
        itemsService.deleteById(id);
    }

}
