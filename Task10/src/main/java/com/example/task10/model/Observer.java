package com.example.task10.model;

import java.util.List;

public interface Observer {

    void update(String stockName, double newPrice);
    String getName();
    List<String> getMessages();
}
