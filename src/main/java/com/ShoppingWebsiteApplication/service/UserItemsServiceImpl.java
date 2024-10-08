package com.ShoppingWebsiteApplication.service;

import com.ShoppingWebsiteApplication.model.UserItems;
import com.ShoppingWebsiteApplication.repository.UserItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserItemsServiceImpl implements UserItemsService {

    @Autowired
    UserItemsRepository userItemsRepository;

    @Override
    public void createUserItem(UserItems userItems) {
        List<Long> itemsId = userItemsRepository.getAllUserItems(userItems.getUserId());
        if (!itemsId.contains(userItems.getUserItemId())) {
            userItemsRepository.createUserItem(userItems);
        } else {
            System.out.println("User already has this item.");
        }
    }


    @Override
    public void deleteUserItem(Long userId, Long ItemId) {
        userItemsRepository.deleteUserItem(userId, ItemId);
    }

    public void deleteUserItemsByUserId(Long userId) {
        userItemsRepository.deleteUserItemsByUserId(userId);
    }

    @Override
    public List<Long> getAllUserItems(Long userId) {

        return userItemsRepository.getAllUserItems(userId);
    }

}
