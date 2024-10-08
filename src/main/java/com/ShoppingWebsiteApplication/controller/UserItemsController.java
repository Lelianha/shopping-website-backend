package com.ShoppingWebsiteApplication.controller;

import com.ShoppingWebsiteApplication.model.Item;
import com.ShoppingWebsiteApplication.model.UserItems;
import com.ShoppingWebsiteApplication.service.ItemService;
import com.ShoppingWebsiteApplication.service.UserItemsService;
import com.ShoppingWebsiteApplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/userItems")
public class UserItemsController {

    @Autowired
    UserItemsService userItemsService;

    @Autowired
    ItemService itemService;

    @Autowired
    UserService userService;

    @PostMapping(value = "/create")
    @CrossOrigin
    public void createUserItem(@RequestBody UserItems userItems) {
        Boolean userStatus = userService.userStatus(userItems.getUserId());
        if (userStatus == true) {
            userItemsService.createUserItem(userItems);
        }
    }

    @CrossOrigin
    @DeleteMapping(value = "/delete/{userId}/{ItemId}")
    private void deleteUserItem(@PathVariable("userId") Long userId, @PathVariable("ItemId") Long ItemId) {
        userItemsService.deleteUserItem(userId, ItemId);
    }

    @CrossOrigin
    @GetMapping(value = "/getAll/{userId}")
    public List<Item> getAllUserItems(@PathVariable("userId") Long userId) {
        Boolean userStatus = userService.userStatus(userId);
        if (userStatus == true) {
            List<Long> itemIds = userItemsService.getAllUserItems(userId);
            List<Item> itemsList = new ArrayList<>();
            for (Long id : itemIds) {
                itemsList.add(itemService.getItemById(id));
            }
            return itemsList;
        }

        return null;
    }

}
