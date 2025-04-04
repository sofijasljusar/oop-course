package com.cafe.solid;

import java.util.List;

public abstract class ReceiptGenerator {

    private final TotalCalculator totalCalculator;
    private final DiscountCalculator discountCalculator;

    public ReceiptGenerator(TotalCalculator totalCalculator, DiscountCalculator discountCalculator) {
        this.totalCalculator = totalCalculator;
        this.discountCalculator = discountCalculator;
    }

    public abstract void  generateReceipt(OrderManager orderManager);

    public double calculateDiscount(double total) {
        return discountCalculator.calculateDiscount(total);
    }
    public double calculateTotal(OrderManager orderManager) {
        return totalCalculator.calculateTotal(orderManager.getOrder());
    }

}
