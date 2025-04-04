package com.cafe.solid;

public class ConsoleReceiptGenerator extends ReceiptGenerator {
    public ConsoleReceiptGenerator(TotalCalculator totalCalculator, DiscountCalculator discountCalculator) {
        super(totalCalculator, discountCalculator);
    }

    @Override
    public void generateReceipt(OrderManager orderManager) {
        System.out.println("Чек:");
        for (OrderItem item : orderManager.getOrder()) {
            System.out.println(item.dish + " x " + item.quantity + " - " + (item.quantity * item.price) + " грн");
        }
        double total = calculateTotal(orderManager);
        System.out.println("Загальна сума: " + total + "грн");

        double discount =  calculateDiscount(total);

        System.out.println("Загальна сума після знижок: " + discount + " грн");

    }
}
