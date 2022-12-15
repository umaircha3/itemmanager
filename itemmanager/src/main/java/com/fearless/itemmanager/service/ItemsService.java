package com.fearless.itemmanager.service;

import com.fearless.itemmanager.model.Item;
import com.fearless.itemmanager.model.ItemRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.*;

@Service
public class ItemsService {
    Map<Long, String> itemsMap = new HashMap<Long, String>();

    public Item createItem(ItemRequest itemRequest) {

        Item item = new Item(generateIdForItem(), itemRequest.getName());

        itemsMap.put(item.getId(), item.getName());

        // items.add(item);

        return item;
    }

    public List<Item> getAllItems() {

        List<Item> response = new ArrayList<>();
        for(Map.Entry<Long, String> entry: itemsMap.entrySet()){
            response.add(new Item(entry.getKey(), entry.getValue()));
        }

        return response;
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

    public Item getItemById(Long id) {
        return itemsMap.containsKey(id) ? new Item(id, itemsMap.get(id)) : null;
    }

    public Item updateItemById(Long id, ItemRequest itemRequest) {

        if(itemsMap.containsKey(id)){
            itemsMap.put(id, itemRequest.getName());
            return new Item(id, itemsMap.get(id));
        }
        return null;
    }

    public void deleteAllItems() {
        itemsMap.clear();
    }

    public void deleteById(Long id) {
        if(itemsMap.containsKey(id)){
            itemsMap.remove(id);
        }
    }
}
