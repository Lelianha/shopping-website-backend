package com.ShoppingWebsiteApplication.model;

import java.time.LocalDate;

public class Order {

    private Long id;

    private Long userId;

    private LocalDate orderDate;

    private String shippingAddress;

    private Double totalPrice;

    private OrderStatus status;

    private Long NumberOfItems;


    public Order() {
    }

    public Order(Long id, Long userId, LocalDate orderDate, String shippingAddress, Double totalPrice, OrderStatus status, Long NumberOfItems) {
        this.id = id;
        this.userId = userId;
        this.orderDate = orderDate;
        this.shippingAddress = shippingAddress;
        this.totalPrice = totalPrice;
        this.status = status;
        this.NumberOfItems = NumberOfItems;
    }

    public Order(Long userId, LocalDate orderDate) {
        this.userId = userId;
        this.orderDate = orderDate;

    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }


    public LocalDate getOrderDate() {
        orderDate = LocalDate.now();
        return orderDate;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public Long getNumberOfItems() {
        return NumberOfItems;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }


    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public void setNumberOfItems(Long numberOfItems) {
        NumberOfItems = numberOfItems;
    }
}
