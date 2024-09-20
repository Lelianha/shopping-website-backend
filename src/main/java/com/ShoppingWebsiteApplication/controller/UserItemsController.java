package com.ShoppingWebsiteApplication.controller;

import com.ShoppingWebsiteApplication.model.Item;
import com.ShoppingWebsiteApplication.model.UserItems;
import com.ShoppingWebsiteApplication.service.ItemService;
import com.ShoppingWebsiteApplication.service.UserItemsService;
import com.ShoppingWebsiteApplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.util.StringUtils;
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
    public void  createUserItem(@RequestBody UserItems userItems)  {
        Boolean userStatus = userService.userStatus(userItems.getUserId());
        if (userStatus==true) {
            userItemsService.createUserItem(userItems);
        }
    }


//    @PostMapping(value = "/create")
//    @CrossOrigin
//    public void  createUserItems(@RequestBody UserItems userItems) {
//
//        List<Long> itemIds = userItemsService.getAllUserItems(userItems.getUserName());
////        List<Long> itemIdsIntered = userItems.getItems();
//
//        boolean ans = itemIds.isEmpty();
//        System.out.println(ans);
//        System.out.println(itemIds);
//
//
//        if (ans == true) {
//            userItemsService.createUserItems(userItems);
//            System.out.println("First Created!!!");
//
//        } else {
//            for (long id : itemIds) {
//                if(userItems.getItems().contains(id)){
//                        System.out.println("Found in list");
//
//                    }
//                else {
//                        userItemsService.createUserItems(userItems);
//
//
//                }
//            }
//        }
//    }

//    @PostMapping(value = "/create")
//    @CrossOrigin
//    public void  createUserItems(@RequestBody UserItems userItems) {
//
//        List<Long> itemIds = userItemsService.getAllUserItems(userItems.getUserName());
//        List<Long> itemIdsIntered = userItems.getItems();
//
//        boolean ans = itemIds.isEmpty();
//        System.out.println(ans);
//        System.out.println(itemIds);
//
//
//        if (ans == true) {
//            userItemsService.createUserItems(userItems);
//            System.out.println("First Created!!!");
//
//        } else {
//            for (long id : itemIds) {
//                if(userItems.getItems().contains(id)){
//                    System.out.println("Found in list");
//
//                }
//                else {
//                    userItemsService.createUserItems(userItems);
//
//
//                }
//            }
//        }
//    }



//    @CrossOrigin
//    @DeleteMapping(value="/delete/{userItemsId}")
//    private void deleteUserItemsById(@PathVariable("userItemsId") Long userItemsId)
//    {
//        userItemsService.deleteUserItemsById(userItemsId);
//    }

    @CrossOrigin
    @DeleteMapping(value="/delete/{userId}/{ItemId}")
    private void deleteUserItem(@PathVariable("userId") Long userId,@PathVariable("ItemId") Long ItemId)
    {
        userItemsService.deleteUserItem(userId,ItemId);
    }



/////// delete حسب اليوزير نيم او اليوزير اي دي والايتم اي دي عشان نمحى من البوست مان

//    @CrossOrigin
//    @DeleteMapping(value="/delete/name/{userId}")
//    private void deleteUserItemsByUserId(@PathVariable("userId") Long userId)
//    {
//        userItemsService.deleteUserItemsByUserId(userId);
//    }

//    @CrossOrigin
//    @DeleteMapping(value="/delete/{ItemsId}")
//    private void deleteUserItemsById(@PathVariable("ItemsId") Long ItemsId)
//    {
//        userItemsService.deleteUserItemsById(ItemsId);
//    }

//    @CrossOrigin
//    @GetMapping(value = "/getAll/{userId}")
//    public  List<Item> getAllUserItems(@PathVariable("userId") Long userId){
//        List<Long> itemIds =  userItemsService.getAllUserItems(userId);
//        List<Item> itemsList = new ArrayList<>();
//        for (Long id: itemIds) {
//            itemsList.add(itemService.getItemById(id));
//        }
//        return itemsList;
//    }

    @CrossOrigin
    @GetMapping(value = "/getAll/{userId}")
    public  List<Item> getAllUserItems(@PathVariable("userId") Long userId){
//        try {
        Boolean userStatus = userService.userStatus(userId);
        if(userStatus==true) {
            List<Long> itemIds = userItemsService.getAllUserItems(userId);
            List<Item> itemsList = new ArrayList<>();
            for (Long id : itemIds) {
                itemsList.add(itemService.getItemById(id));
            }
            return itemsList;
        }

        return  null;
    }


    //    @CrossOrigin
//    @GetMapping(value = "/get/{userName}")
//    public  List<Item> getAllUserItems(@PathVariable("userName") String userName){
//        List<Long> itemIds =  userItemsService.getAllUserItems(userName);
//        List<Item> itemsList = new ArrayList<>();
//        for (Long id: itemIds) {
//            itemsList.add(itemService.getItemById(id));
//        }
//        return itemsList;
//    }

}
