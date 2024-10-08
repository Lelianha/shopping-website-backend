package com.ShoppingWebsiteApplication.service;

import com.ShoppingWebsiteApplication.model.Item;
import com.ShoppingWebsiteApplication.model.Order;
import com.ShoppingWebsiteApplication.model.OrderItems;
import com.ShoppingWebsiteApplication.model.OrderStatus;
import com.ShoppingWebsiteApplication.repository.ItemRepository;
import com.ShoppingWebsiteApplication.repository.OrderItemsRepository;
import com.ShoppingWebsiteApplication.repository.OrderRepository;
import javassist.expr.NewArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderItemsServiceImpl implements OrderItemsService {

    @Autowired
    OrderItemsRepository orderItemsRepository;
    @Autowired
    ItemService itemService;
    @Autowired
    OrderService orderService;
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ItemRepository itemRepository;



    @Override
    public void calculate(OrderItems orderItems) {
        Double total=0.0;
        Order order = orderService.getOrderById(orderItems.getOrderId());
        List<Long> Items =orderItemsRepository.getAllOrderItems(orderItems.getOrderId());

        for (Long id: Items) {
            total += (itemService.getItemPriceById(id)*orderItemsRepository.getOrderItemQuantityById(orderItems.getOrderId(),id));
        }
        order.setTotalPrice(total);
        orderRepository.updateTotalPrice(orderItems.getOrderId(),order);
        if(total==0.0){
            orderRepository.deleteOrderById(orderItems.getOrderId());

        }
    }

    @Override
    public void calculateByOrderId(Long orderId) {
        Double total=0.0;
        Order order = orderService.getOrderById(orderId);
        List<Long> Items =orderItemsRepository.getAllOrderItems(orderId);

        for (Long id: Items) {
            total += (itemService.getItemPriceById(id)*orderItemsRepository.getOrderItemQuantityById(orderId,id));
        }
        order.setTotalPrice(total);
        orderRepository.updateTotalPrice(orderId,order);
        if(total==0.0){
            orderRepository.deleteOrderById(orderId);

        }
    }



    @Override
    public void createOrderItem(OrderItems orderItems) {

        if(orderRepository.getAllTempOrdersByUserId(orderItems.getUserId()).size()==0)
        {
            Order newOrder = new Order(orderItems.getUserId(), LocalDate.now());
            orderRepository.createOrder(newOrder);
            List<Long> arrOfOrders = orderService.getAllOrdersByUserId(orderItems.getUserId());
            int s = arrOfOrders.size() - 1;
            Long lastOrderId = arrOfOrders.get(s);
            Long quantity = itemRepository.getItemQuantityById(orderItems.getOrderItemId());
            if (quantity == 0) {
                System.out.println("Item is out of stock!!"+quantity);
            } else if (quantity!=0) {
                OrderItems newOrderItems = new OrderItems(orderItems.getUserId(), lastOrderId, orderItems.getOrderItemId());
                orderItemsRepository.createOrderItem(newOrderItems);
                calculate(newOrderItems);
                itemRepository.decItemQuantity(orderItems.getOrderItemId());
            }
        }
        else {

            if (orderRepository.getAllTempOrdersByUserId(orderItems.getUserId()).size() != 0) {
                List<Long> arrOfTempOrders = orderRepository.getAllTempOrdersByUserId(orderItems.getUserId());
                int s = arrOfTempOrders.size() - 1;
                Long lastTempOrderId = arrOfTempOrders.get(s);
                List<Long> allOrderItems= orderItemsRepository.getAllOrderItems(lastTempOrderId);
                Long quantity = itemRepository.getItemQuantityById(orderItems.getOrderItemId());
                if (quantity == 0) {
                } else if (quantity!=0&&allOrderItems.contains(orderItems.getOrderItemId())) {
                    orderItemsRepository.incOrderItemQuantity(lastTempOrderId,orderItems.getOrderItemId());
                    OrderItems newOrderItems = new OrderItems(orderItems.getUserId(), lastTempOrderId);
                    calculate(newOrderItems);
                    itemRepository.decItemQuantity(orderItems.getOrderItemId());
                }
                else if (quantity!=0&&(!allOrderItems.contains(orderItems.getOrderItemId()))){
                    OrderItems newOrderItems = new OrderItems(orderItems.getUserId(), lastTempOrderId, orderItems.getOrderItemId());
                    orderItemsRepository.createOrderItem(newOrderItems);
                    calculate(newOrderItems);
                    itemRepository.decItemQuantity(orderItems.getOrderItemId());
                }
            }
        }
    }


    @Override
    public void deleteOrderItemsById(Long orderId, Long ItemsId) {

        Long quantity =orderItemsRepository.getOrderItemQuantityTemp(orderId,ItemsId);

        if(quantity>1){
            itemRepository.updateItemQuantity(ItemsId,quantity);

        } else if (quantity==1) {
            itemRepository.incItemQuantity(ItemsId);
        }
        orderItemsRepository.deleteOrderItemsById(orderId, ItemsId);

        List<Long> allItems=orderItemsRepository.getAllOrderItems(orderId);
        if(allItems.size()>0){
            calculateByOrderId(orderId);
        }
        else{
            orderRepository.deleteOrderById(orderId);
        }
    }

    @Override
    public void deleteOrderItemsByOrderId(Long orderId) {
        List<Long> orderItems =orderItemsRepository.getAllOrderItems(orderId);
        for (Long id:orderItems) {
            Long quantity =orderItemsRepository.getOrderItemQuantityTemp(orderId,id);
            if(quantity>1){
                itemRepository.updateItemQuantity(id,quantity);

            } else if (quantity==1) {

                itemRepository.incItemQuantity(id);
            }

        }
        orderItemsRepository.deleteOrderItemsByOrderId(orderId);
        orderRepository.deleteOrderById(orderId);
    }
    @Override
    public void deleteCloseOrderItemsByOrderId(Long orderId) {
        orderItemsRepository.deleteCloseOrderItemsByOrderId(orderId);
        orderRepository.deleteOrderById(orderId);

    }




    //هاي لازم تنمحى وعند عدن اصلا دمحى الكونتتي
    @Override
    public void incOrderItemQuantity(Long orderId, Long ItemsId) {
        orderItemsRepository.incOrderItemQuantity(orderId, ItemsId);
    }



    @Override
    public void decOrderItemQuantity(Long orderId, Long ItemsId) {
        Long quantity =orderItemsRepository.getOrderItemQuantityTemp(orderId,ItemsId);
        if(quantity>1){
            orderItemsRepository.decOrderItemQuantity(orderId, ItemsId);
            itemRepository.incItemQuantity(ItemsId);
        } else if (quantity==1) {
            orderItemsRepository.decOrderItemQuantity(orderId, ItemsId);
            itemRepository.incItemQuantity(ItemsId);
            orderItemsRepository.deleteOrderItemsById(orderId,ItemsId);
        }
        calculateByOrderId(orderId);
    }




    @Override
    public  Long getOrderItemQuantityTemp(Long userId,Long itemId) {
        return orderItemsRepository.getOrderItemQuantityTemp(userId,itemId);
    }
    @Override
    public List<Long> getAllOrderItems(Long orderId) {
        return orderItemsRepository.getAllOrderItems(orderId);
    }

    @Override
    public List<Long> getAllOrderIds() {
        return orderItemsRepository.getAllOrderIds();
    }

}
