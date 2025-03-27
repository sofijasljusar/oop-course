package com.cafe.solid;

import java.util.ArrayList;
import java.util.List;

public class OrderManager {
    private List<OrderItem> order;
    private double orderTotal;

    public OrderManager() {
        order = new ArrayList<>();
    }

    public void takeOrder(String dish, int quantity, Menu menu) {
        double price = menu.getItemPrice(dish);
        order.add(new OrderItem(dish, quantity, price));
    }

    public double calculateTotal() {
        orderTotal = 0;
        for (OrderItem item : order) {
            orderTotal += item.quantity * item.price;
        }
        return orderTotal;
    }

    public boolean isOrderEmpty() {
        return order.isEmpty();
    }

    public List<OrderItem> getOrder() {
        return order;
    }

}
