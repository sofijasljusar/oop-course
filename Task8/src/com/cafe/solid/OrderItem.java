package com.cafe.solid;

public class OrderItem {
    public final String dish;
    public final int quantity;
    public final double price;

    public OrderItem(String dish, int quantity, double price) {
        this.dish = dish;
        this.quantity = quantity;
        this.price = price;
    }
}

//public record OrderItem(String dish, int quantity, double price) {
//}
