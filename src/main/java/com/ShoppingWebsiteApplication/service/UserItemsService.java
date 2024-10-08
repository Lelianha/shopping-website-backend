package com.ShoppingWebsiteApplication.service;

import com.ShoppingWebsiteApplication.model.UserItems;

import java.util.List;

public interface UserItemsService {
    void createUserItem(UserItems userItems);

    void deleteUserItem(Long userId, Long ItemId);

    void deleteUserItemsByUserId(Long userId);

    List<Long> getAllUserItems(Long userId);
}
