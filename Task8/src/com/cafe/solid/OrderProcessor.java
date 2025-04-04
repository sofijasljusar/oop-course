package com.cafe.solid;

public interface OrderProcessor {
    void takeOrder(String dish, int quantity, MenuService menu);
}
