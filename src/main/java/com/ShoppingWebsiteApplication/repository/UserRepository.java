package com.ShoppingWebsiteApplication.repository;

import com.ShoppingWebsiteApplication.model.CustomUser;

import java.util.List;

public interface UserRepository {
    void createUser(CustomUser customUser);
    CustomUser findUserByUsername(String username);
    Boolean userStatus(Long userId);

    CustomUser getUserById(Long userId);
    Long getUserId(String userName);

    void deleteUserById(Long userId);

    void updateUserActive(CustomUser customUser, String userName);

void updateUser(CustomUser customUser, Long userId);

    List<CustomUser> getAllUsers();


}
