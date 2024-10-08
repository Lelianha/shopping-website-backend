package com.ShoppingWebsiteApplication.controller;


import com.ShoppingWebsiteApplication.model.Item;
import com.ShoppingWebsiteApplication.model.Order;
//import com.ShoppingWebsiteApplication.model.UserOrderRequest;
//import com.ShoppingWebsiteApplication.model.UserOrderResponse;
import com.ShoppingWebsiteApplication.model.OrderItems;
import com.ShoppingWebsiteApplication.model.OrderStatus;
import com.ShoppingWebsiteApplication.repository.ItemRepository;
import com.ShoppingWebsiteApplication.repository.OrderItemsRepository;
import com.ShoppingWebsiteApplication.repository.OrderRepository;
import com.ShoppingWebsiteApplication.service.OrderItemsService;
import com.ShoppingWebsiteApplication.service.OrderService;
import com.ShoppingWebsiteApplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/order")

public class OrderController {


    @Autowired
    OrderService orderService;

    @Autowired
    OrderItemsService orderItemsService;
    @Autowired
    UserService userService;
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderItemsRepository orderItemsRepository;

    @Autowired
    ItemRepository itemRepository;

    @PostMapping(value = "/create")
    @CrossOrigin
    public Long createOrder(@RequestBody Order order)  {
        Boolean userStatus = userService.userStatus(order.getUserId());
        if (userStatus==true) {
            return orderService.createOrder(order);
        }
        return null;
    }


    @CrossOrigin
    @GetMapping(value = "/get/{orderId}")
    public Order getOrderById(@PathVariable Long orderId) {
        return orderService.getOrderById(orderId);
    }



    @CrossOrigin
    @GetMapping(value = "/get/tempOrder/{userId}")
    public Order getTempOrderByUserId(@PathVariable Long userId) {
        return orderService.getTempOrderByUserId(userId);
    }


//    @CrossOrigin
//    @DeleteMapping(value="/delete/{orderId}")
//    private void deleteOrderById(@PathVariable("orderId") Long orderId)
//    {
//        List<Long> orderItems =orderItemsRepository.getAllOrderItems(orderId);
//
//        OrderStatus status= orderRepository.getOrderStatusById(orderId);
//        if (status.equals(OrderStatus.TEMP)) {
//            orderService.deleteOrderById(orderId);
//            for (Long id:orderItems) {
//                itemRepository.incItemQuantity(id);
//            }
//        }
//    }


    @CrossOrigin
    @DeleteMapping(value="/delete/{orderId}")
    public void deleteOrderById(@PathVariable("orderId") Long orderId) {

        OrderStatus status = orderRepository.getOrderStatusById(orderId);

        if (status.equals(OrderStatus.TEMP)) {
            orderItemsService.deleteOrderItemsByOrderId(orderId);
        } else {
            System.out.println("Order cannot be deleted. Status is not TEMP: " + status);
        }
    }



    @CrossOrigin
    @PutMapping(value = "/update/shippingAddress/{orderId}")
    private void updateOrderShippingAddress(@PathVariable Long orderId ,@RequestBody Order order)
    {
        orderService.updateOrderShippingAddress(orderId , order);
    }


    @CrossOrigin
    @PutMapping(value = "/update/status/{orderId}")
    private void updateOrderStatus(@PathVariable Long orderId )
    {
        Order order = orderService.getOrderById(orderId);
      //  if (order.getNumberOfItems()>0&&(order.getShippingAddress()!="No Address")) {
        if (order.getNumberOfItems() > 0 && !"No Address".equals(order.getShippingAddress())) {

            orderService.updateOrderStatus(orderId);
        }
    }

    @CrossOrigin
    @GetMapping(value = "/getAll")
    public List<Order> getAllOrders(){

        return orderService.getAllOrders();
    }

    @CrossOrigin
    @GetMapping(value = "/getAll/userName/{userName}")
    public List<Long> getAllOrdersByUserId(@PathVariable Long userId){
        Boolean userStatus = userService.userStatus(userId);
        if (userStatus==true) {
            return orderService.getAllOrdersByUserId(userId);
        }
        return null;
    }

    @CrossOrigin
    @GetMapping(value = "/getAll/CloseOrders/{userId}")
    public List<Order> getAllCloseOrdersByUserId(@PathVariable Long userId){
        Boolean userStatus = userService.userStatus(userId);
        if (userStatus==true) {
            return orderService.getAllCloseOrdersByUserId(userId);
        }
        return null;
    }
}


