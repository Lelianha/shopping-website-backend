package com.ShoppingWebsiteApplication.service;

import com.ShoppingWebsiteApplication.model.Item;
import com.ShoppingWebsiteApplication.model.Order;
import com.ShoppingWebsiteApplication.model.OrderItems;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface OrderItemsService {
    void calculate(OrderItems orderItems);
    void calculateByOrderId(Long orderId);
    void createOrderItem(OrderItems orderItems);
    void deleteOrderItemsById( Long orderId, Long ItemsId);
    void deleteOrderItemsByOrderId(Long orderId);

    void incOrderItemQuantity( Long orderId, Long ItemsId);
    void decOrderItemQuantity( Long orderId, Long ItemsId);
    List<Long> getAllOrderItems(Long orderId);
    List<Long> getAllOrderIds();
    Long getOrderItemQuantityTemp(Long userId,Long itemId);


}
