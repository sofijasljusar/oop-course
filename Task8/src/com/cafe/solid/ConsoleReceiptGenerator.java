package com.cafe.solid;

import java.util.List;

public class ConsoleReceiptGenerator implements ReceiptGenerator{
    @Override
    public void generateReceipt(List<OrderItem> order, double total) {
        System.out.println("Чек:");
        for (OrderItem item : order) {
            System.out.println(item.dish + " x " + item.quantity + " - " + (item.quantity * item.price) + " грн");
        }
        System.out.println("Загальна сума: " + total + "грн");
    }
}
