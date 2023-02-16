package com.ShoppingWebsiteApplication.repository;

import com.ShoppingWebsiteApplication.model.Item;
import com.ShoppingWebsiteApplication.repository.mapper.ItemMapper;
import com.ShoppingWebsiteApplication.repository.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository

public  class ItemRepositoryImpl implements ItemRepository {

    private static final String ITEM_TABLE_NAME = "item";

    @Autowired
    JdbcTemplate jdbcTemplate;



    @Override
    public Long createItem(Item item) {
        String sql = "INSERT INTO " + ITEM_TABLE_NAME + " (title, price, quantity, picture_url) VALUES (?, ? ,?, ?)";
        jdbcTemplate.update(sql, item.getTitle() , item.getPrice() , item.getQuantity() , item.getPictureUrl());
        return jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID();", Long.class);
    }


    @Override
    public Item getItemById(Long itemId) {
        String sql = "SELECT * FROM " + ITEM_TABLE_NAME + " WHERE id=?";
        try {
            return jdbcTemplate.queryForObject(sql, new ItemMapper(), itemId);
        } catch (EmptyResultDataAccessException error){
            return null;
        }
    }


    @Override
    public void deleteItemById(Long itemId) {
        String sql = "DELETE FROM " + ITEM_TABLE_NAME + " WHERE id=?";
         jdbcTemplate.update(sql,itemId);
    }



    @Override
    public void updateItem(Item item , Long itemId) {
        String sql = "UPDATE " + ITEM_TABLE_NAME + " SET title=?, price=? ,  quantity=? ,   picture_url=? " +
                " WHERE id=?";
        jdbcTemplate.update(sql, item.getTitle() , item.getPrice() , item.getQuantity() , item.getPictureUrl() , itemId);
    }

    @Override
    public List<Item> getAllItems() {
        String sql = "SELECT * FROM " + ITEM_TABLE_NAME ;
        try {
            return jdbcTemplate.query(sql, new ItemMapper());
        } catch (EmptyResultDataAccessException error){
            return null;
        }
    }


}
