package com.ShoppingWebsiteApplication.service;

import com.ShoppingWebsiteApplication.model.Order;
import com.ShoppingWebsiteApplication.model.UserOrderRequest;
import com.ShoppingWebsiteApplication.model.UserOrderResponse;

public interface OrderService {

    UserOrderResponse createOrder (UserOrderRequest userOrderRequest) throws Exception;

    Order getOrderById( Long orderId);

    void deleteOrderById( Long orderId);

    void updateOrder(Long orderId ,  Order order);

}
