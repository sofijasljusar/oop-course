package com.cafe.monolithic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.List;

public class CafeOrder {
    private Map<String, Double> menu;
    private List<OrderItem> order;
    private double totalAmount;

    public CafeOrder() {
        menu = new HashMap<>();
        order = new ArrayList<>();
        totalAmount = 0;

        menu.put("Salad", 50.0);
        menu.put("Cake", 25.0);
        menu.put("Tea", 10.0);
        menu.put("Coffee", 15.0);
    }

    public static void main(String[] args) {
        CafeOrder order = new CafeOrder();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введіть назву страви (або 'x' для завершення замовлення): ");
            String dish = scanner.nextLine();
            if (dish.equalsIgnoreCase("x")) break;
            System.out.println("Введіть кількість: ");
            int quantity = scanner.nextInt();
            scanner.nextLine();

            order.takeOrder(dish, quantity);
        }

        order.calculateTotal();
        order.generateReceipt();

    }

    public void takeOrder(String dish, int quantity) {  // depends on menu, if load dynamically need to change  class
        if (menu.containsKey(dish)) {
            double price = menu.get(dish);
            order.add(new OrderItem(dish, quantity, price));
        } else {
            System.out.println("Помилка: Такої страви немає в меню.");
        }
    }
    public void calculateTotal() {  // depends on order and applies hardcoded discount
        totalAmount = 0;
        for (OrderItem item : order) {
            totalAmount += item.quantity * item.price;
        }

        if (totalAmount >= 300) {  // violating Open-Closed Principle
            System.out.println("Вітаю! При покупці > 300 грн діє знижка -20%");
            System.out.println("Ваша знижка: " + totalAmount + " - " + totalAmount * 0.2 +"грн == " + totalAmount * 0.8 +"грн");
            totalAmount *= 0.8;
        }
    }

    public void generateReceipt() {  // depends on order and totalAmount
        System.out.println("Чек:");
        for (OrderItem item : order) {
            System.out.println(item.dish + " x " + item.quantity + " - " + (item.quantity * item.price) + " грн");
        }
        System.out.println("Загальна сума: " + totalAmount + "грн");
    }

    private static class OrderItem {  // private nested and cannot be used by another class
        public String dish;
        public int quantity;
        public double price;

        public OrderItem(String dish, int quantity, double price) {
            this.dish = dish;
            this.quantity = quantity;
            this.price = price;
        }
    }
}
