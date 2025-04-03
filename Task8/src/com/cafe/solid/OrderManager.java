package com.cafe.solid;

import java.util.ArrayList;
import java.util.List;

public class OrderManager implements OrderProcessor {
    private List<OrderItem> order;

    public OrderManager() {
        order = new ArrayList<>();
    }

    @Override
    public void takeOrder(String dish, int quantity, Menu menu) {
        double price = menu.getItemPrice(dish);
        order.add(new OrderItem(dish, quantity, price));
    }

    public boolean isOrderEmpty() {
        return order.isEmpty();
    }

    public List<OrderItem> getOrder() {
        return order;
    }

}
