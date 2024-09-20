package com.ShoppingWebsiteApplication.controller;


import com.ShoppingWebsiteApplication.model.CustomUser;
import com.ShoppingWebsiteApplication.model.CustomUserRequest;
import com.ShoppingWebsiteApplication.model.Order;
import com.ShoppingWebsiteApplication.model.OrderStatus;
import com.ShoppingWebsiteApplication.repository.ItemRepository;
import com.ShoppingWebsiteApplication.repository.OrderItemsRepository;
import com.ShoppingWebsiteApplication.repository.OrderRepository;
import com.ShoppingWebsiteApplication.service.*;
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
    @Autowired
    ItemRepository itemRepository;
    @Autowired
    OrderItemsRepository orderItemsRepository;


    @PostMapping("/create")
    @CrossOrigin
    public ResponseEntity<?> createUser(@RequestBody CustomUserRequest customUser){
        try{
            userService.createUser(customUser);
            return null;
        } catch (Exception exception){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        }
    }

    @CrossOrigin
    @GetMapping(value = "/get/{userId}")
    public CustomUser getUserById(@PathVariable Long userId){
        return userService.getUserById(userId);
    }

//    @CrossOrigin
//    @GetMapping(value = "/get/status/{userName}")
//    public Boolean userStatus(@PathVariable Long userId){
//        return userService.userStatus(userId);
//    }

    @CrossOrigin
    @GetMapping(value = "/get/id/{userName}")
    public Long getUserId(@PathVariable String userName){
        return userService.getUserId(userName);
    }

    @DeleteMapping(value = "/delete/{userId}")
    private void deleteUserById(@PathVariable("userId") Long userId)
    {
        List<Long> orderIds = orderService.getAllOrdersByUserId(userId);

        for (Long orderId: orderIds) {
            OrderStatus orderStatus=orderRepository.getOrderStatusById(orderId);
            if( orderStatus.equals(OrderStatus.CLOSE)) {
                orderItemsService.deleteOrderItemsByOrderId(orderId);
            }
            else if (orderStatus.equals(OrderStatus.TEMP)) {
                List<Long> orderItems =orderItemsRepository.getAllOrderItems(orderId);
                for (Long orderItemId:orderItems) {
                    Long quantity =orderItemsRepository.getOrderItemQuantityTemp(userId,orderItemId);
                    itemRepository.updateItemQuantity(orderItemId,quantity);
                }
                orderItemsService.deleteOrderItemsByOrderId(orderId);
            }
        }
        orderService.deleteOrderByUserId(userId);
        userItemsService.deleteUserItemsByUserId(userId);
        userService.deleteUserById(userId);
        userService.deleteUserById(userId);

    }

//    @CrossOrigin
//    @DeleteMapping(value = "/delete/name/{userName}")
//    private void deleteUserByName(@PathVariable("userName") String userName)
//    {
//        String newUserName = "'"+ userName+"'";
//        List<Long> orderIds = orderService.getAllOrdersByUserName(newUserName);
//        System.out.println(orderIds);
//
//        for (Long orderId: orderIds) {
//            OrderStatus orderStatus=orderRepository.getOrderStatusById(orderId);
//            System.out.print(orderId);
//
//            System.out.print(orderStatus);
//            if( orderStatus.equals(OrderStatus.CLOSE)) {
//                orderItemsService.deleteOrderItemsByUserName(orderId);
//
//
//
//            }
//            else if (orderStatus.equals(OrderStatus.TEMP)) {
//                List<Long> orderItems =orderItemsRepository.getAllOrderItems(orderId);
//                System.out.println(orderItems);
//                for (Long orderItemId:orderItems) {
//                    System.out.println(orderItemId);
//                    Long quantity =orderItemsRepository.getOrderItemQuantity(userName,orderItemId);
//                    System.out.println("quantity"+quantity);
//
//                    itemRepository.incItemQuantitys(orderItemId,quantity);
//                }
//                orderItemsService.deleteOrderItemsByUserName(orderId);
//
//            }
//        }
//        orderService.deleteOrderByUserName(userName);
//        userItemsService.deleteUserItemsByUserName(userName);
//        userService.deleteUserByName(userName);
//    }

//    @CrossOrigin
//    @PutMapping(value = "/update/{userName}")
//    private void updateUser(@PathVariable String userName,@RequestBody CustomUser customUser)
//    {
//        userService.updateUser(customUser, userName);
//    }

    @CrossOrigin
    @PutMapping(value = "/update/{userId}")
    private void updateUser(@PathVariable Long userId,@RequestBody CustomUser customUser)
    {
        userService.updateUser(customUser, userId);
    }

    @CrossOrigin
    @PutMapping(value = "/update/active/{userName}")
    private void updateUserActive(@PathVariable String userName,@RequestBody CustomUser customUser)
    {
        userService.updateUserActive(customUser, userName);
    }

    @CrossOrigin
    @GetMapping(value = "/getAll")
    public List<CustomUser> getAllUsers(){
        return userService.getAllUsers();
    }

}