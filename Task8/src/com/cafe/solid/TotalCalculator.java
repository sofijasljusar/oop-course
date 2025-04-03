package com.cafe.solid;
import java.util.ArrayList;
import java.util.List;

public class TotalCalculator {

    public double calculateTotal(List<OrderItem> order) {
            double orderTotal = 0;
        for (OrderItem item : order) {
            orderTotal += item.quantity * item.price;
        }
        return orderTotal;
    }
}
