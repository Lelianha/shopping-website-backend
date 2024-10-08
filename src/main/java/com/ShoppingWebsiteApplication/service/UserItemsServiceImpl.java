package com.ShoppingWebsiteApplication.service;


import com.ShoppingWebsiteApplication.model.Item;
import com.ShoppingWebsiteApplication.model.OrderItems;
import com.ShoppingWebsiteApplication.model.UserItems;
import com.ShoppingWebsiteApplication.repository.UserItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserItemsServiceImpl implements UserItemsService {

    @Autowired
    UserItemsRepository userItemsRepository;


//    @Override
//    public void createUserItems(UserItems userItems) {
//        try {
//            userItemsRepository.createUserItems(userItems);
//        }
//        catch (Exception e){
//        }
//    }


    @Override
    public void createUserItem(UserItems userItems) {
        // Retrieve the list of item IDs for the user once
        List<Long> itemsId = userItemsRepository.getAllUserItems(userItems.getUserId());

        // Check if the user already has the item
        if (!itemsId.contains(userItems.getUserItemId())) {
            // If not, create the new user item
            userItemsRepository.createUserItem(userItems);
        } else {
            // Optionally, log that the item already exists for the user
            System.out.println("User already has this item.");
        }
    }


    @Override
    public void deleteUserItem(Long userId,Long ItemId) {
        userItemsRepository.deleteUserItem(userId,ItemId);
    }

    public void deleteUserItemsByUserId(Long userId) {
        userItemsRepository.deleteUserItemsByUserId(userId);
    }


//    @Override
//    public List<Long> getAllUserItems(Long userId) {
//        return  userItemsRepository.getAllUserItems(userId);
//    }

    @Override
    public List<Long> getAllUserItems(Long userId) {

        return userItemsRepository.getAllUserItems(userId);
    }

}
