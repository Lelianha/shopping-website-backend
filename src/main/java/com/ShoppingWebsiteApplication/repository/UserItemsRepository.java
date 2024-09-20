package com.ShoppingWebsiteApplication.repository;

import com.ShoppingWebsiteApplication.model.Item;
import com.ShoppingWebsiteApplication.model.OrderItems;
import com.ShoppingWebsiteApplication.model.UserItems;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface UserItemsRepository {
    void   createUserItem( UserItems userItems);
    void deleteUserItem(Long userId,Long ItemId);
    void deleteUserItemsByUserId(Long userId );

    List<Long> getAllUserItems( Long userId);


}
