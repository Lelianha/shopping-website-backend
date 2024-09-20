package com.ShoppingWebsiteApplication.repository;


import com.ShoppingWebsiteApplication.model.Item;
import com.ShoppingWebsiteApplication.model.OrderItems;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class OrderItemsRepositoryImpl implements OrderItemsRepository {

    private static final String ORDER_ITEMS_TABLE_NAME = "orderItems";
    private static final String USER_ITEMS_TABLE_NAME = "userItems";
    private static final String ORDERS_TABLE_NAME = "orders";
    private static final String USER_TABLE_NAME = "user";


    @Autowired
    JdbcTemplate jdbcTemplate;


    @Override
    public void createOrderItem(OrderItems orderItems) {
        String sql = "INSERT INTO " + ORDER_ITEMS_TABLE_NAME + " (item_id, quantity, user_id,order_id) VALUES (?,?,?,?)";
        jdbcTemplate.update(sql, orderItems.getOrderItemId(),1,orderItems.getUserId(), orderItems.getOrderId());

    }



    @Override
    public void deleteOrderItemsById(Long orderId, Long ItemsId) {
        String sql = "DELETE FROM " + ORDER_ITEMS_TABLE_NAME + " WHERE order_id=? AND item_id=?";
        jdbcTemplate.update(sql,orderId,ItemsId);
    }
    @Override
    public void deleteOrderItemsByOrderId(Long orderId) {
        String sql = "DELETE FROM " + ORDER_ITEMS_TABLE_NAME + " WHERE order_id=? ";
        jdbcTemplate.update(sql,orderId);
    }




//    @Override
//    public void updateOrderItemQuantity( Long orderId, Long ItemsId) {
//        String sql = "UPDATE " + ORDER_ITEMS_TABLE_NAME + " SET  quantity=(quantity+1) " +
//                " WHERE order_id=? AND item_id=?";
//        jdbcTemplate.update(sql, orderId,ItemsId);
//    }
    @Override
    public void incOrderItemQuantity( Long orderId, Long ItemsId) {
        String sql = "UPDATE " + ORDER_ITEMS_TABLE_NAME + " SET  quantity=(quantity+1) " +
                " WHERE order_id=? AND item_id=?";
        jdbcTemplate.update(sql, orderId,ItemsId);
    }
    @Override
    public void decOrderItemQuantity( Long orderId, Long ItemsId) {
        String sql = "UPDATE " + ORDER_ITEMS_TABLE_NAME + " SET  quantity=(quantity-1) " +
                " WHERE order_id=? AND item_id=?";
        jdbcTemplate.update(sql, orderId,ItemsId);
    }

    //    @Override
//    public List<Long> getAllOrderItems(Long orderId) {
//        String sql = "SELECT item_id FROM " + ORDER_ITEMS_TABLE_NAME + " WHERE order_id=" + orderId ;
//        try{
////             return jdbcTemplate.query(sql, Long.class);
//            return jdbcTemplate.queryForList(sql, Long.class);
//
//
//        }
//        catch (EmptyResultDataAccessException error){
//            return null;
//        }
//    }

//    @Override
//    public Double getPrice(OrderItems orderItems) {
//        String sql = "SELECT SUM(price) FROM " + ITEM_TABLE_NAME  + " LEFT JOIN "+ ORDER_ITEMS_TABLE_NAME+
//                " ON item.id=orderItems.item_id"
//                +" LEFT JOIN "+ ORDERS_TABLE_NAME+" ON orderItems.order_id=orders.id "+" WHERE orders.id=?";
//        try {
//            return jdbcTemplate.queryForObject(sql, Double.class,orderItems.getOrderId());
//        } catch (EmptyResultDataAccessException error){
//            return null;
//        }
//    }



    @Override
    public List<Long> getAllOrderItems(Long orderId) {
        String sql = "SELECT item_id FROM " + ORDER_ITEMS_TABLE_NAME + " WHERE order_id=" + orderId ;
        try{
            return jdbcTemplate.queryForList(sql, Long.class);
//        return jdbcTemplate.query(sql, orderId);

        }
        catch (EmptyResultDataAccessException error){
            return null;
        }
    }


//    @Override
//    public Long numberOfOrderItemsInOrder(Long orderId) {
//        String sql = "SELECT COUNT( item_id) FROM " + ORDER_ITEMS_TABLE_NAME + " WHERE order_id=" + orderId;
//        return jdbcTemplate.queryForObject(sql, Long.class);
//    }

//    @Override
//    public Long quantity (Long orderId,Long itemId) {
//        String sql = "SELECT COUNT( item_id) FROM " + ORDER_ITEMS_TABLE_NAME + " WHERE order_id=" + orderId + "AND item_id=" +itemId;
//        return jdbcTemplate.queryForObject(sql, Long.class);
//    }

    @Override
    public Long getOrderItemQuantityTemp(Long orderId,Long itemId) {
        String sql = "SELECT quantity FROM " + ORDER_ITEMS_TABLE_NAME + " LEFT JOIN " + ORDERS_TABLE_NAME + " ON orderItems.order_id = orders.id"
                + " WHERE orderItems.order_id=? AND orderItems.item_id=? AND orders.status='TEMP' ";
        try {
            return jdbcTemplate.queryForObject(sql, Long.class,orderId,itemId);
        } catch (EmptyResultDataAccessException error){
            return null;
        }
    }


    @Override
    public Long getOrderItemQuantityById(Long orderId,Long itemId) {
        String sql = "SELECT quantity FROM " + ORDER_ITEMS_TABLE_NAME + " WHERE order_id=? AND item_id=?";
        try {
            return jdbcTemplate.queryForObject(sql, Long.class,orderId,itemId);
        } catch (EmptyResultDataAccessException error){
            return null;
        }
    }


//    @Override
//    public List<OrderItems> getAllOrdersItems() {
//        String sql = "SELECT item_id FROM " + ORDER_ITEMS_TABLE_NAME ;
//        return jdbcTemplate.queryForList(sql, OrderItems.class);
//    }

    @Override
    public List<Long> getAllOrderIds() {
        String sql = "SELECT distinct order_id FROM " + ORDER_ITEMS_TABLE_NAME ;

        try {
            return jdbcTemplate.queryForList(sql,Long.class);
        } catch (EmptyResultDataAccessException error){
            return null;
        }    }


//    @Override
//    public List<HashMap<Long, Item>> getAllTry(Long orderId) {
//        String sql = "SELECT item_id FROM " + ORDER_ITEMS_TABLE_NAME + " WHERE order_id=" + orderId ;
////        try{
////            return jdbcTemplate.queryForList(sql, Long.class);
////        }
////        catch (EmptyResultDataAccessException error){
////            return null;
////        }
////        String sql = "SELECT item_id FROM " + ORDER_ITEMS_TABLE_NAME ;
////        return jdbcTemplate.queryForList(sql, Maplass);
//        return null;
//    }

}