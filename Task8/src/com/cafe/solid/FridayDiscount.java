package com.cafe.solid;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class FridayDiscount implements DiscountStrategy{
    private final double discountAmount = 0.5;

    @Override
    public double calculateDiscount(double total) {
        LocalDate today = LocalDate.now();
        boolean isFriday = today.getDayOfWeek() == DayOfWeek.WEDNESDAY;
        if (isFriday) {
            System.out.println("😎Happy Friday! Знижка -50%!!!");
            System.out.println(total * discountAmount);
            return total * discountAmount;
        }
        return total;
    }

}
