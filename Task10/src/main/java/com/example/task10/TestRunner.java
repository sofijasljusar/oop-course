package com.example.task10;

import com.example.task10.model.Investor;
import com.example.task10.model.StockExchange;

public class TestRunner {
    public static void main(String[] args) {
        System.out.println("Testing Logic before UI:");

        StockExchange stockMarket = new StockExchange(2);
        stockMarket.addStock("Apple", 135.0);
        stockMarket.addStock("Google", 170.0);
        stockMarket.addStock("Amazon", 200.0);

        stockMarket.deleteStock("Amazon");


        System.out.println(stockMarket.getAllStocksInfo());

        Investor investor1 = new Investor("Alice");
        Investor investor2 = new Investor("Bob");
        Investor broker = new Investor("Clara");


        stockMarket.attach("Google", investor1);
        stockMarket.attach("Apple", investor1);
        stockMarket.attach("Apple", investor2);
        stockMarket.attach("Apple", broker);

        stockMarket.updateStockPrice("Google", 1550.00);
        stockMarket.updateStockPrice("Apple", 1250.00);

        stockMarket.deleteStock("Apple");
        stockMarket.updateStockPrice("Apple", 10000.00);

    }
}
