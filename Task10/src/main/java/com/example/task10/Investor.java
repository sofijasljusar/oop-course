package com.example.task10;

public class Investor implements Observer{
    private final String name;

    public Investor(String name) {
        this.name = name;
    }

    public void update(String stockName, double newPrice) {
        System.out.println("test mode print * " + name + ":");
        System.out.println("Нова ціна для акції " + stockName + ": $" + newPrice);
    }
}
