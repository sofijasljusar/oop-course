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

    public double calculateDiscount(double total) {
        for (DiscountStrategy discount : discounts) {
            System.out.println("applying discount...");
            total = discount.applyDiscount(total);
        }
        return total;
    }

}
