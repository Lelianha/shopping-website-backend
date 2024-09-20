package com.ShoppingWebsiteApplication.model;

import java.util.List;

public class UserItems {
    private Long userId;

    private Long userItemId;


    public UserItems(Long userId, Long userItemId) {
        this.userId = userId;
        this.userItemId = userItemId;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getUserItemId() {
        return userItemId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setUserItemId(Long userItemId) {
        this.userItemId = userItemId;
    }
}
