package com.cafe.solid;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class FridayDiscount implements DiscountStrategy{
    private final double discountAmount = 0.5;

    @Override
    public double calculateDiscount(double total) {
        LocalDate today = LocalDate.now();
        boolean isFriday = today.getDayOfWeek() == DayOfWeek.THURSDAY;
        if (isFriday) {
            System.out.printf("😎 Happy Friday! Знижка -%d%%!!!\n", (int) (discountAmount*100));

            return total * discountAmount;
        }
        return 0;
    }

}
