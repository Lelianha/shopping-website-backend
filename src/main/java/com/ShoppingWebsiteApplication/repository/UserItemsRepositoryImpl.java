package com.ShoppingWebsiteApplication.repository;

import com.ShoppingWebsiteApplication.model.UserItems;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserItemsRepositoryImpl implements UserItemsRepository {
    private static final String USER_ITEMS_TABLE_NAME = "userItems";

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void createUserItem(UserItems userItems) {
        String sql = "INSERT INTO " + USER_ITEMS_TABLE_NAME + " (item_id,   user_id) VALUES (?,?)";
        jdbcTemplate.update(sql, userItems.getUserItemId(), userItems.getUserId());
    }

    @Override
    public void deleteUserItem(Long userId, Long ItemId) {
        String sql = "DELETE FROM " + USER_ITEMS_TABLE_NAME + " WHERE user_id=? AND item_id=?";
        jdbcTemplate.update(sql, userId, ItemId);
    }

    @Override
    public void deleteUserItemsByUserId(Long userId) {
        String sql = "DELETE FROM " + USER_ITEMS_TABLE_NAME + " WHERE user_id=?";
        jdbcTemplate.update(sql, userId);
    }

    @Override
    public List<Long> getAllUserItems(Long userId) {
        String sql = "SELECT item_id FROM " + USER_ITEMS_TABLE_NAME + " WHERE user_id=" + userId;
        try {
            return jdbcTemplate.queryForList(sql, Long.class);
        } catch (EmptyResultDataAccessException error) {
            return null;
        }
    }


}