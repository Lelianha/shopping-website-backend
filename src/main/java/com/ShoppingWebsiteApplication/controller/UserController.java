package com.ShoppingWebsiteApplication.controller;

import com.ShoppingWebsiteApplication.model.CustomUser;
import com.ShoppingWebsiteApplication.model.CustomUserRequest;
import com.ShoppingWebsiteApplication.model.OrderStatus;
import com.ShoppingWebsiteApplication.repository.OrderRepository;
import com.ShoppingWebsiteApplication.service.OrderItemsService;
import com.ShoppingWebsiteApplication.service.OrderService;
import com.ShoppingWebsiteApplication.service.UserItemsService;
import com.ShoppingWebsiteApplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    OrderItemsService orderItemsService;
    @Autowired
    OrderService orderService;
    @Autowired
    UserItemsService userItemsService;
    @Autowired
    OrderRepository orderRepository;


    @PostMapping("/create")
    @CrossOrigin
    public ResponseEntity<?> createUser(@RequestBody CustomUserRequest customUser) {
        try {
            userService.createUser(customUser);
            return null;
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        }
    }

    @CrossOrigin
    @GetMapping(value = "/get/{userId}")
    public CustomUser getUserById(@PathVariable Long userId) {
        return userService.getUserById(userId);
    }

    @CrossOrigin
    @GetMapping(value = "/get/id/{userName}")
    public Long getUserId(@PathVariable String userName) {
        return userService.getUserId(userName);
    }

    @CrossOrigin
    @GetMapping(value = "/get/userStatus/{userId}")
    public Boolean userStatus(@PathVariable Long userId) {
        return userService.userStatus(userId);
    }

    @CrossOrigin
    @DeleteMapping(value = "/delete/{userId}")
    private void deleteUserById(@PathVariable("userId") Long userId) {
        List<Long> orderIds = orderService.getAllOrdersByUserId(userId);

        for (Long orderId : orderIds) {
            OrderStatus orderStatus = orderRepository.getOrderStatusById(orderId);
            if (orderStatus.equals(OrderStatus.CLOSE)) {
                orderItemsService.deleteCloseOrderItemsByOrderId(orderId);
            } else if (orderStatus.equals(OrderStatus.TEMP)) {
                orderItemsService.deleteOrderItemsByOrderId(orderId);
            }
        }
        userItemsService.deleteUserItemsByUserId(userId);
        orderService.deleteOrderByUserId(userId);
        userService.deleteUserById(userId);
    }


    @CrossOrigin
    @PutMapping(value = "/update/{userId}")
    private void updateUser(@PathVariable Long userId, @RequestBody CustomUser customUser) {
        userService.updateUser(customUser, userId);
    }

    @CrossOrigin
    @PutMapping(value = "/update/active/{userName}")
    private void updateUserActive(@PathVariable String userName, @RequestBody CustomUser customUser) {
        userService.updateUserActive(customUser, userName);
    }

    @CrossOrigin
    @PutMapping(value = "/update/logout/{userId}")
    private void UserLogOut(@PathVariable Long userId, @RequestBody CustomUser customUser) {
        userService.UserLogOut(customUser, userId);
    }

    @CrossOrigin
    @GetMapping(value = "/getAll")
    public List<CustomUser> getAllUsers() {
        return userService.getAllUsers();
    }

}