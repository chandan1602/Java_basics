package com.example.guavaDemo;

import java.util.List;

public class DListenableFuture {
}

class CartInfo {
    private String cartId;
    private String customerName;
    private List<String> cartItems;

    public CartInfo() {}

    public CartInfo(String cartId, String customerName, List<String> cartItems) {
        this.cartId = cartId;
        this.customerName = customerName;
        this.cartItems = cartItems;
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<String> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<String> cartItems) {
        this.cartItems = cartItems;
    }

    @Override
    public String toString() {
        return "CartInfo{" +
                "cartId='" + cartId + '\'' +
                ", customerName='" + customerName + '\'' +
                ", cartItems=" + cartItems +
                '}';
    }
}