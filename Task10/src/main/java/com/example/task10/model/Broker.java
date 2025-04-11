package com.example.task10.model;

import java.util.ArrayList;
import java.util.List;

public class Broker implements Observer{
    private final String name;
    private final List<String> messages = new ArrayList<>();

    public Broker(String name) {
        this.name = name;
    }

    public void update(String stockName, double newPrice) {
        String message = "Нова ціна для акції " + stockName + ": $" + newPrice;
        System.out.println("test mode print * " + name + ":");
        System.out.println(message);
        messages.addFirst(message);
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
