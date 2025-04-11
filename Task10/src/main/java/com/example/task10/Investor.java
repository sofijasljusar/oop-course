package com.example.task10;

import java.util.ArrayList;
import java.util.List;

public class Investor implements Observer{
    private final String name;
    private final List<String> messages = new ArrayList<>();
    public Investor(String name) {
        this.name = name;
    }

    // TODO
    public void update(String stockName, double newPrice) {
        String message = "Нова ціна для акції " + stockName + ": $" + newPrice;
        System.out.println("test mode print * " + name + ":");
        System.out.println(message);
        messages.add(message);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<String> getMessages() {
        return messages;
    }
}
