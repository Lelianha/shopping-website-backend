package com.ShoppingWebsiteApplication.repository;

//import com.ShoppingWebsiteApplication.model.Item;
import com.ShoppingWebsiteApplication.model.User;
import com.ShoppingWebsiteApplication.repository.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Repository
public class UserRepositoryImpl implements UserRepository {


    private static final String USER_TABLE_NAME = "user";

    @Autowired
    JdbcTemplate jdbcTemplate;



    @Override
    public Long createUser(User user) {
        String sql = "INSERT INTO " + USER_TABLE_NAME + " (first_name,  last_name, email, password , phone, address  ) VALUES (?, ? , ? , ? , ? , ?)";
        jdbcTemplate.update(sql, user.getFirstName() , user.getLastName() , user.getEmail(), user.getPassword(), user.getPhone(), user.getAddress());
        return jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID();", Long.class);
    }

    @Override
    public User getUserById(Long userId) {
        String sql = "SELECT * FROM " + USER_TABLE_NAME + " WHERE id=?";
        try {
            return jdbcTemplate.queryForObject(sql, new UserMapper(), userId);
        } catch (EmptyResultDataAccessException error){
            return null;
        }
    }


    @Override
    public void deleteUserById(Long userId) {
        String sql = "DELETE FROM " + USER_TABLE_NAME + " WHERE id=?";
         jdbcTemplate.update(sql,userId);
    }

    @Override
    public void updateUser(User user , Long userId) {
        String sql = "UPDATE " + USER_TABLE_NAME + " SET first_name=?, last_name=? , email=? , password=? , phone=?, address=? " +
                " WHERE id=?";
        jdbcTemplate.update(sql,user.getFirstName() , user.getLastName() , user.getEmail(), user.getPassword(), user.getPhone(), user.getAddress(), userId);
    }

}





