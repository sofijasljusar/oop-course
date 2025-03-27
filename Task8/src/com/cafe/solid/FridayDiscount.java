package com.cafe.solid;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class FridayDiscount implements DiscountStrategy{

    @Override
    public double applyDiscount(double total) {
        LocalDate today = LocalDate.now();
        boolean isFriday = today.getDayOfWeek() == DayOfWeek.THURSDAY;
        if (isFriday) {
            return total * 0.5;
        }
        return total;
    }

}
