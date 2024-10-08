package com.ShoppingWebsiteApplication.repository;

import com.ShoppingWebsiteApplication.model.Order;
import com.ShoppingWebsiteApplication.model.OrderStatus;

import java.util.List;

public interface OrderRepository {

    Long createOrder(Order order);

    Order getOrderById(Long orderId);

    Order getTempOrderByUserId(Long orderId);

    OrderStatus getOrderStatusById(Long userId);

    void deleteOrderById(Long orderId);

    void deleteOrderByUserId(Long userId);

    void updateOrderShippingAddress(Long orderId, Order order);

    void updateOrderStatus(Long orderId);

    void updateTotalPrice(Long orderId, Order order);

    List<Order> getAllOrders();

    List<Long> getAllOrdersByUserId(Long userId);

    List<Order> getAllCloseOrdersByUserId(Long userId);

    List<Long> getAllTempOrdersByUserId(Long userId);

}
