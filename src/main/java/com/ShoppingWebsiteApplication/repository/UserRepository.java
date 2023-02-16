package com.ShoppingWebsiteApplication.repository;

import com.ShoppingWebsiteApplication.model.User;

import java.util.List;
import java.util.Map;

public interface UserRepository {
    Long createUser( User user);

    User getUserById(Long userId);

    void deleteUserById(Long userId);

    void updateUser( User user , Long userId);



}
