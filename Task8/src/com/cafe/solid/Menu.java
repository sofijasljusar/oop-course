package com.cafe.solid;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Menu {
    private Map<String, Double> menu;

    public Menu() {
        menu = new HashMap<>();
    }

    public void addItem(String itemName, double itemPrice) {
        menu.put(itemName, itemPrice);
    }
    // OCP
    public void deleteItem(String itemName) {
        menu.remove(itemName);
    }

    public void printMenu() {
        System.out.println("\uD83D\uDCCB Меню:");

        Set<String> keys = menu.keySet();
        for (String key : keys) {
            System.out.println(key + " --- " + menu.get(key) + " грн");
        }
    }

    public boolean itemInMenu(String itemName) {
        return menu.containsKey(itemName);
    }

    public double getItemPrice(String itemName) {
        return menu.get(itemName);
    }




}
