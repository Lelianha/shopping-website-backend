package com.ShoppingWebsiteApplication.repository;

import com.ShoppingWebsiteApplication.model.Order;
import com.ShoppingWebsiteApplication.repository.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class OrderRepositoryImpl  implements OrderRepository {

    private static final String ORDERS_TABLE_NAME = "orders";

    @Autowired
    JdbcTemplate jdbcTemplate;



    @Override
    public void createOrder(Order order) {
        String sql = "INSERT INTO " + ORDERS_TABLE_NAME + " (user_id, order_date,  shipping_address , total_price , status , item_id ) VALUES (?, ? , ? , ? , ? , ?)";
        jdbcTemplate.update(sql, order.getUserId() , order.getOrderDate() , order.getShippingAddress(), order.getTotalPrice(), order.getStatus().name() , order.getItemId());
    }

    @Override
    public Order getOrderById(Long orderId) {
        String sql = "SELECT * FROM " + ORDERS_TABLE_NAME + " WHERE id=?";
        try {
            return jdbcTemplate.queryForObject(sql, new OrderMapper(), orderId);
        } catch (EmptyResultDataAccessException error){
            return null;
        }
    }


    @Override
    public void deleteOrderById(Long orderId) {
        String sql = "DELETE FROM " + ORDERS_TABLE_NAME + " WHERE id=?";
        jdbcTemplate.update(sql,orderId);
    }


    @Override
    public void updateOrder( Long orderId , Order order) {
        String sql = "UPDATE " + ORDERS_TABLE_NAME + " SET user_id=?, order_date=?,  shipping_address=? , total_price=? , status=? , item_id=?  " +
                " WHERE id=?";
        jdbcTemplate.update(sql,order.getUserId() , order.getOrderDate() , order.getShippingAddress(), order.getTotalPrice(), order.getStatus().name() , order.getItemId(), orderId);
    }




}
