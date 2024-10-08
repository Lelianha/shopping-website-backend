package com.ShoppingWebsiteApplication.service;
import com.ShoppingWebsiteApplication.model.Item;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ItemService {
    Long createItem(Item item );

    Item getItemById( Long itemId);
    Double getItemPriceById(Long itemId);

    void deleteItemById(Long itemId);


    void updateItem(Item item, Long itemId);
    void updateItemQuantity(Long itemId,Long quantity);

    List<Item> getAllItems();




}
