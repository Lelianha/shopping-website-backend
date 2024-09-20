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
//        List<Long> itemsId = userItemsRepository.getAllUserItems(userItems.getUserId());
//        itemsId.forEach(itemId -> {
//            if (!(itemsId.contains(userItems.getUserItemId()))) {
//                userItemsRepository.createUserItem(userItems);
//            }
//        });
        if(userItemsRepository.getAllUserItems(userItems.getUserId()).size() != 0){
        List<Long> itemsId = userItemsRepository.getAllUserItems(userItems.getUserId());
//        itemsId.forEach(itemId -> {
//            if (!(itemsId.contains(userItems.getUserItemId()))) {
//                userItemsRepository.createUserItem(userItems);
//            }
            if (!((itemsId.contains(userItems.getUserItemId())))) {
                userItemsRepository.createUserItem(userItems);
            }
//        });
        }
        else if(userItemsRepository.getAllUserItems(userItems.getUserId()).size() == 0){
            userItemsRepository.createUserItem(userItems);

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
