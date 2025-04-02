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
        ArrayList<Double> subtractedSums = new ArrayList<>();
        for (DiscountStrategy discount : discounts) {
            double sum = discount.calculateDiscount(total);
            subtractedSums.add(sum);
        }
        for (double sum : subtractedSums) {
            System.out.printf("%f - %f\n", total, sum);
        }
        for (double sum : subtractedSums) {
            total -= sum;
        }
        return Math.max(total, 0);
    }

}
