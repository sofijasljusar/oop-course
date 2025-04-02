package com.cafe.solid;

import java.time.LocalDate;

public class ChristmasDiscount implements DiscountStrategy{
    private final double discountAmount = 0.75;

    @Override
    public double calculateDiscount(double total) {
        LocalDate today = LocalDate.now();
        boolean isChristmas = today.getMonthValue() == 4 && today.getDayOfMonth() == 2;
        if (isChristmas) {
            System.out.println("🎄 Merry Christmas! Знижка -25%! 🎁");
            System.out.println(total * discountAmount);
            return total * discountAmount;
        }
        return total;
    }
}
