package com.ShoppingWebsiteApplication.model;

public class OrderItems {
    private Long userId;

    private Long orderId;

    private Long quantity;

    private Long orderItemId;


    public OrderItems(Long userId, Long orderId, Long orderItemId) {
        this.userId = userId;
        this.orderId = orderId;
        this.orderItemId = orderItemId;
    }

    public OrderItems(Long userId, Long orderId, Long quantity, Long orderItemId) {
        this.userId = userId;
        this.orderId = orderId;
        this.quantity = quantity;
        this.orderItemId = orderItemId;

    }

    public OrderItems(Long userId, Long orderId) {
        this.userId = userId;
        this.orderId = orderId;
    }

    public OrderItems() {
    }

    public Long getUserId() {
        return userId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public Long getQuantity() {
        return quantity;
    }

    public Long getOrderItemId() {
        return orderItemId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public void setOrderItemId(Long orderItemId) {
        this.orderItemId = orderItemId;
    }
}

