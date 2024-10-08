package com.ShoppingWebsiteApplication.repository;


import com.ShoppingWebsiteApplication.model.UserItems;

import java.util.List;

public interface UserItemsRepository {
    void createUserItem(UserItems userItems);

    void deleteUserItem(Long userId, Long ItemId);

    void deleteUserItemsByUserId(Long userId);

    List<Long> getAllUserItems(Long userId);


}
