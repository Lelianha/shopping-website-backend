package com.ShoppingWebsiteApplication.service;

import com.ShoppingWebsiteApplication.model.CustomUser;
import com.ShoppingWebsiteApplication.model.CustomUserRequest;

import java.util.List;

public interface UserService {
    void createUser(CustomUserRequest user) throws Exception;

    CustomUser findUserByUsername(String username);

    Boolean userStatus(Long userId);

    Long getUserId(String userName);

    CustomUser getUserById(Long userId);

    void deleteUserById(Long userId);

    void updateUserActive(CustomUser customUser, String userName);

    void UserLogOut(CustomUser customUser, Long userId);

    void updateUser(CustomUser customUser, Long userId);

    List<CustomUser> getAllUsers();
}
