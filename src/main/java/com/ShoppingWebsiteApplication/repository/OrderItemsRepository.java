package com.ShoppingWebsiteApplication.repository;

import com.ShoppingWebsiteApplication.model.OrderItems;

import java.util.List;

public interface OrderItemsRepository {
    void createOrderItem(OrderItems orderItems);

    void deleteOrderItemsById(Long orderId, Long ItemsId);

    void deleteOrderItemsByOrderId(Long orderId);

    void deleteCloseOrderItemsByOrderId(Long orderId);

    void incOrderItemQuantity(Long orderId, Long ItemsId);

    void decOrderItemQuantity(Long orderId, Long ItemsId);

    Long getOrderItemQuantityTemp(Long orderId, Long itemId);

    Long getOrderItemQuantityById(Long orderId, Long itemId);

    List<Long> getAllOrderItems(Long orderId);

    List<Long> getAllOrderIds();


}
