package com.cafe.solid;


public class PrintedReceiptGenerator extends ReceiptGenerator {
    public PrintedReceiptGenerator(TotalCalculator totalCalculator, DiscountCalculator discountCalculator) {
        super(totalCalculator, discountCalculator);
    }

    @Override
    public void generateReceipt(OrderManager orderManager) {
        System.out.println("🖨️ Друкується чек...");
        System.out.println("\n╔════════════════════════════════╗");
        for (OrderItem item : orderManager.getOrder()) {
            System.out.println("      " + item.dish + " x " + item.quantity + " - " + (item.quantity * item.price) + " грн");
        }
        System.out.println("══════════════════════════════════");
        System.out.println("      Загальна сума: " + calculateTotal(orderManager) + "грн");
        System.out.println("╚════════════════════════════════╝\n");

    }
}