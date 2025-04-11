package com.example.task10.model;

import java.util.List;

public interface Observer {
// TODO: add 2 methods UI and console!

    void update(String stockName, double newPrice);
    String getName();
    List<String> getMessages();
}
