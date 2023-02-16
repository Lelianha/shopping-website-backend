package com.ShoppingWebsiteApplication.service;
import com.ShoppingWebsiteApplication.model.User;
//import com.ShoppingWebsiteApplication.model.UserRequest;
//import com.ShoppingWebsiteApplication.model.UserResponse;

import java.util.List;
import java.util.Map;

public interface UserService {
    Long createUser( User user);
    User getUserById(Long userId);
    void deleteUserById( Long userId);
    void updateUser( User user , Long userId);
}
