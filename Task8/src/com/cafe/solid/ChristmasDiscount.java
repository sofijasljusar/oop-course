package com.cafe.solid;

import java.time.LocalDate;

public class ChristmasDiscount implements DiscountStrategy{
    private final double discountAmount = 0.25;

    @Override
    public double calculateDiscount(double total) {
        LocalDate today = LocalDate.now();
        boolean isChristmas = today.getMonthValue() == 4 && today.getDayOfMonth() == 3;
        if (isChristmas) {
            System.out.printf("🎄 Merry Christmas! Знижка -%d%%! 🎁\n", (int) (discountAmount*100));
            return total * discountAmount;
        }
        return 0;
    }
}
