package com.cafe.solid;

import java.util.List;

public interface ReceiptGenerator {

    void generateReceipt(List<OrderItem> order, double total);

}
