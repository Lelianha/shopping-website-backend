package com.ShoppingWebsiteApplication.controller;


import com.ShoppingWebsiteApplication.model.User;
import com.ShoppingWebsiteApplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;


    @PostMapping(value = "/create")
    @CrossOrigin
    public Long createUser(@RequestBody User user) {
        return userService.createUser(user);
    }



    @GetMapping(value = "/get/{userId}")
    public User getUserById(@PathVariable Long userId){
        return userService.getUserById(userId);
    }



    @DeleteMapping(value = "/delete/{userId}")
    private void deleteUserById(@PathVariable("userId") Long userId)
    {
        userService.deleteUserById(userId);
    }


    @PutMapping(value = "/update/{userId}")
    private void updateUser(@PathVariable Long userId,@RequestBody User user)
    {
        userService.updateUser(user , userId);
    }



}