package com.cafe.solid;

import java.util.ArrayList;
import java.util.List;

public class DiscountCalculator {
    private List<DiscountStrategy> discounts;

    public DiscountCalculator() {
        discounts = new ArrayList<>();
    }

    public void addDiscount(DiscountStrategy discount) {
        discounts.add(discount);
    }

    public void removeDiscount(DiscountStrategy discount) {
        discounts.remove(discount);
    }

    // accumulative discount
    public double calculateDiscount(double total) {
        double discountedTotal = total;
        for (DiscountStrategy discount : discounts) {
            double sum = discount.calculateDiscount(total);
            discountedTotal -= sum;
        }
        return Math.max(discountedTotal, 0);
    }

}
