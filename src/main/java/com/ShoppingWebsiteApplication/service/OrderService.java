package com.ShoppingWebsiteApplication.service;

import com.ShoppingWebsiteApplication.model.Item;
import com.ShoppingWebsiteApplication.model.Order;
import com.ShoppingWebsiteApplication.model.OrderItems;
//import com.ShoppingWebsiteApplication.model.UserOrderRequest;
//import com.ShoppingWebsiteApplication.model.UserOrderResponse;

import java.util.List;

public interface OrderService {

    Long createOrder (Order order ) ;

    Order getOrderById( Long orderId);
    Order getTempOrderByUserId( Long UserId);

    void deleteOrderById( Long orderId);
    void deleteOrderByUserId(Long userId);

    void updateOrderShippingAddress(Long orderId ,  Order order);
    void updateOrderStatus( Long orderId);
    List<Order> getAllOrders();
    List<Long> getAllOrdersByUserId(Long userId);
    List<Order> getAllCloseOrdersByUserId(Long userId);


}
