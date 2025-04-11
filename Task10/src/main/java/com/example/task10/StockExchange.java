package com.example.task10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StockExchange implements Subject{
    private static StockExchange instance;
    private Map<String, Stock> stocks = new HashMap<>();
    private Map<String, List<Observer>> subscribers = new HashMap<>();
    int maxSubscribers;

    public StockExchange(int maxSubscribers) {
        this.maxSubscribers = maxSubscribers;
    }

    public static StockExchange getInstance() {
        if (instance == null) {
            instance = new StockExchange(2);
        }
        return instance;
    }

    public void addStock(String name, double price) {
        stocks.put(name, new Stock(name, price));
        subscribers.put(name, new ArrayList<>());
    }

    public void deleteStock(String name) {
        stocks.remove(name);
        subscribers.remove(name);
    }

    public String getAllStocksInfo() {
        StringBuilder infoString = new StringBuilder("УСІ АКЦІЇ НА БІРЖІ:");
        for (final String stock: stocks.keySet()) {
            infoString.append("\n").append(stock);
        }
        return infoString.toString();
    }

    @Override
    public void attach(String stockName, Observer observer) {
        if (stocks.containsKey(stockName)) {
            if (subscribers.get(stockName).size() >= maxSubscribers) {
                System.out.println("Не можна додати підписника, ліміт досягнуто для акції " + stockName);
            } else {
                subscribers.get(stockName).add(observer);
                System.out.println("Підписник успішно доданий до акції " + stockName);
            }
        } else {
            System.out.println("Акцію не знайдено.");
        }
    }

    @Override
    public void detach(String stockName, Observer observer) {
        if (stocks.containsKey(stockName)) {
            subscribers.get(stockName).remove(observer);
        }
        else {
            System.out.println("Акцію не знайдено.");
        }
    }

    @Override
    public void notifyObservers(String stockName) {
        Stock stock = stocks.get(stockName);
        for (Observer subscriber: subscribers.get(stockName)) {
            subscriber.update(stockName, stock.getPrice());
        }
    }

    public void updateStockPrice(String stockName, double newPrice) {
        if (stocks.containsKey(stockName)) {
            Stock stock = stocks.get(stockName);
            stock.setPrice(newPrice);
            notifyObservers(stockName);
        } else {
            System.out.println("Акцію не знайдено.");
        }
    }

    //TODO: rename methods

    // Returns a list of stock names for the ListView
    public List<String> getAllStockNames() {
        return new ArrayList<>(stocks.keySet());
    }

    public Stock getStock(String name) {
        return stocks.get(name);
    }

    public List<Observer> getSubscribers(String stockName) {
        return subscribers.get(stockName);
    }

    public Observer getUserByName(String name) {
        for (String stock : getAllStockNames()) {
            for (Observer observer : getSubscribers(stock)) {
                if (observer.getName().equals(name)) {
                    return observer;
                }
            }
        }
        return null;
    }



}
