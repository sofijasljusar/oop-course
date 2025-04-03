package com.cafe.solid;

import java.util.List;

public class PrintedReceiptGenerator implements ReceiptGenerator{
    @Override
    public void generateReceipt(List<OrderItem> order, double total) {
        System.out.println("🖨️ Друкується чек...");
        System.out.println("\n╔════════════════════════════════╗");
        for (OrderItem item : order) {
            System.out.println("      " + item.dish + " x " + item.quantity + " - " + (item.quantity * item.price) + " грн");
        }
        System.out.println("══════════════════════════════════");
        System.out.println("      Загальна сума: " + total + "грн");
        System.out.println("╚════════════════════════════════╝\n");

    }
}