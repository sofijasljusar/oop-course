package com.example.task10.model;

public interface Subject {

    void attach(String stockName, Observer observer);

    void detach(String stockName, Observer observer);

    void notifyObservers(String stockName);

}
