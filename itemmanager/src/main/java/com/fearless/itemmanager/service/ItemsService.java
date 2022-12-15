package com.fearless.itemmanager.service;

import com.fearless.itemmanager.model.Item;
import com.fearless.itemmanager.model.ItemRequest;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ItemsService {

    List<Item> items = new ArrayList<Item>();
    Map<Long, String> itemsMap = new HashMap<Long, String>();

    public Item createItem(ItemRequest itemRequest) {

        Item item = new Item(generateIdForItem(), itemRequest.getName());

        itemsMap.put(item.getId(), item.getName());

        items.add(item);

        return item;
    }

    public List<Item> getAllItems() {
        return items;
    }

    private Long generateIdForItem() {


        Long range = 1234567L;
        Random r = new Random();
        Long id = (long) (r.nextDouble() * range);

        if (itemsMap.containsKey(id)){
            return generateIdForItem();
        } else {
            return id;
        }
    }

}
