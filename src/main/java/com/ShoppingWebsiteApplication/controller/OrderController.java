package com.ShoppingWebsiteApplication.controller;


import com.ShoppingWebsiteApplication.model.Order;
import com.ShoppingWebsiteApplication.model.UserOrderRequest;
import com.ShoppingWebsiteApplication.model.UserOrderResponse;
import com.ShoppingWebsiteApplication.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")

public class OrderController {


        @Autowired
        OrderService orderService;

    @PostMapping(value = "/create")
     @CrossOrigin
    public UserOrderResponse createOrder(@RequestBody UserOrderRequest userOrderRequest) throws Exception {
        return orderService.createOrder(userOrderRequest);
    }


        @GetMapping(value = "/get/{orderId}")
        public Order getOrderById(@PathVariable Long orderId){
            return orderService.getOrderById(orderId);
        }



        @DeleteMapping(value="/delete/{orderId}")
        private void deleteOrderById(@PathVariable("orderId") Long orderId)
        {
            orderService.deleteOrderById(orderId);
        }


        @PutMapping(value = "/update/{orderId}")
        private void updateOrder(@PathVariable Long orderId ,@RequestBody Order order)
        {
            orderService.updateOrder(orderId , order);
        }



    }

