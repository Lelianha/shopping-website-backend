//package com.ShoppingWebsiteApplication.repository;
//
//import com.ShoppingWebsiteApplication.model.Item;
//import com.ShoppingWebsiteApplication.model.Order;
//import com.ShoppingWebsiteApplication.model.OrderItems;
//
//import java.util.List;
//
//public interface OrderItemsRepository {
//    void createOrderItems( OrderItems orderItems);
//
//    void deleteOrderItemsById(Long orderItemsId);
//
//    List<Item> getAllOrderItems(Long orderId);
//}

package com.ShoppingWebsiteApplication.repository;

import com.ShoppingWebsiteApplication.model.Item;
import com.ShoppingWebsiteApplication.model.Order;
import com.ShoppingWebsiteApplication.model.OrderItems;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface OrderItemsRepository {
    void createOrderItem(OrderItems orderItems);
    void deleteOrderItemsById( Long orderId, Long ItemsId);
    void deleteOrderItemsByOrderId(Long orderId);
    void incOrderItemQuantity( Long orderId, Long ItemsId);
    void decOrderItemQuantity( Long orderId, Long ItemsId);

    Long getOrderItemQuantityTemp(Long orderId,Long itemId);
    Long getOrderItemQuantityById(Long orderId,Long itemId);
    List<Long> getAllOrderItems(Long orderId);
    List<Long> getAllOrderIds();


}
