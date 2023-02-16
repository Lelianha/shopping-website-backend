package com.ShoppingWebsiteApplication.service;

//import com.ShoppingWebsiteApplication.model.Item;
import com.ShoppingWebsiteApplication.model.User;
//import com.ShoppingWebsiteApplication.model.UserRequest;
//import com.ShoppingWebsiteApplication.model.UserResponse;
import com.ShoppingWebsiteApplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public  class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;


    @Override
    public Long createUser(User user) {
        return userRepository.createUser(user);
    }

    @Override
    public User getUserById(Long userId) {
        return userRepository.getUserById(userId);
    }



    @Override
    public void deleteUserById(Long userId) {
         userRepository.deleteUserById(userId);
    }

    @Override
    public void updateUser(User user , Long userId) {userRepository.updateUser(user, userId);}



}
