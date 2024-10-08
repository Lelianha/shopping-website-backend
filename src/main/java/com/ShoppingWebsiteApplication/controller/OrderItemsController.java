package com.ShoppingWebsiteApplication.controller;

import com.ShoppingWebsiteApplication.model.Item;
import com.ShoppingWebsiteApplication.model.OrderItems;
import com.ShoppingWebsiteApplication.service.ItemService;
import com.ShoppingWebsiteApplication.service.OrderItemsService;
import com.ShoppingWebsiteApplication.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/orderItems")
public class OrderItemsController {

    @Autowired
    OrderItemsService orderItemsService;

    @Autowired
    ItemService itemService;

    @Autowired
    OrderService orderService;


    @PostMapping(value = "/create")
    @CrossOrigin
    public void createOrderItem(@RequestBody OrderItems orderItems) {
        orderItemsService.createOrderItem(orderItems);

    }

    @CrossOrigin
    @PutMapping(value = "/update/quantity/{orderId}/{ItemsId}")
    private void incOrderItemQuantity(@PathVariable("orderId") Long orderId, @PathVariable("ItemsId") Long ItemsId) {
        orderItemsService.incOrderItemQuantity(orderId, ItemsId);
    }

    @CrossOrigin
    @PutMapping(value = "/decrease/quantity/{orderId}/{ItemsId}")
    private void decOrderItemQuantity(@PathVariable("orderId") Long orderId, @PathVariable("ItemsId") Long ItemsId) {
        orderItemsService.decOrderItemQuantity(orderId, ItemsId);
    }

    @CrossOrigin
    @GetMapping(value = "/get/quantity/item/{userId}/{ItemId}")
    private Long getOrderItemQuantityTemp(@PathVariable("userId") Long userId, @PathVariable("ItemId") Long ItemId) {
        return orderItemsService.getOrderItemQuantityTemp(userId, ItemId);
    }

    @CrossOrigin
    @DeleteMapping(value = "/delete/{orderId}/{ItemsId}")
    private void deleteOrderItemsById(@PathVariable("orderId") Long orderId, @PathVariable("ItemsId") Long ItemsId) {
        orderItemsService.deleteOrderItemsById(orderId, ItemsId);
    }

    @CrossOrigin
    @DeleteMapping(value = "/delete/allItems/{orderId}")
    private void deleteOrderItemsByOrderId(@PathVariable("orderId") Long orderId) {
        orderItemsService.deleteOrderItemsByOrderId(orderId);
    }

    @CrossOrigin
    @DeleteMapping(value = "/delete/userId/{userId}")
    private void deleteOrderItemsByUserName(@PathVariable("userId") Long userId) {
        List<Long> orderIds = orderService.getAllOrdersByUserId(userId);
        for (Long id : orderIds) {
            orderItemsService.deleteOrderItemsByOrderId(id);
        }
    }


    @CrossOrigin
    @GetMapping(value = "/getAll/{orderId}")
    public List<Item> getAllOrderItems(@PathVariable("orderId") Long orderId) {
        List<Long> itemIds = orderItemsService.getAllOrderItems(orderId);
        List<Item> itemsList = new ArrayList<>();
        for (Long id : itemIds) {
            Item item = itemService.getItemById(id);
            item.setQuantity(orderItemsService.getOrderItemQuantityTemp(orderId, id));
            itemService.getItemById(id).setQuantity(orderItemsService.getOrderItemQuantityTemp(orderId, id));
            itemsList.add(item);
        }
        return itemsList;
    }


    @CrossOrigin
    @GetMapping(value = "/getAll/orderIds")
    public List<Long> getAllOrderIds() {
        return orderItemsService.getAllOrderIds();
    }

}
