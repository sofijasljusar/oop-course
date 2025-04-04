package com.cafe.solid;


public class PdfReceiptGenerator extends ReceiptGenerator {
    public PdfReceiptGenerator(TotalCalculator totalCalculator, DiscountCalculator discountCalculator) {
        super(totalCalculator, discountCalculator);
    }

    @Override
    public void generateReceipt(OrderManager orderManager) {
        System.out.println("📄 Чек буде збережений у файлі PDF:");
        System.out.println("\n**********************************");
        for (OrderItem item : orderManager.getOrder()) {
            System.out.println("* " + item.dish + " x " + item.quantity + " - " + (item.quantity * item.price) + " грн");
        }

        System.out.println("**********************************");
        System.out.println("Загальна сума: " + calculateTotal(orderManager) + "грн");
        System.out.println("**********************************\n");

    }
}
