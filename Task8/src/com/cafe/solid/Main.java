package com.cafe.solid;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Menu menu = new Menu();

        menu.addItem("Куліш", 50.0);
        menu.addItem("Шулик", 45.0);
        menu.addItem("Галушки", 30.0);
        menu.addItem("Вергуни", 60.0);
        menu.addItem("Потапці", 30.0);

        menu.printMenu();


        OrderManager orderManager = new OrderManager();

        Scanner scanner = new Scanner(System.in);
        boolean isOrdering = true;
        while (isOrdering) {
            System.out.println("Введіть назву страви (або 'x' для завершення замовлення): ");
            String dish = scanner.nextLine();

            if (dish.equalsIgnoreCase("x")) {
                isOrdering = false;
            } else if (!menu.itemInMenu(dish)){
                System.out.println("Помилка! Такої страви немає в меню!");
            } else {
                System.out.println("Введіть кількість: ");
                int quantity = scanner.nextInt();
                scanner.nextLine();
                orderManager.takeOrder(dish, quantity, menu);
            }
        }

        TotalCalculator totalCalculator = new TotalCalculator();
        ReceiptGenerator receiptGenerator = new PrintedReceiptGenerator();
        DiscountCalculator discountCalculator = new DiscountCalculator();
        discountCalculator.addDiscount(new FridayDiscount());
        discountCalculator.addDiscount(new ChristmasDiscount());


        if (!orderManager.isOrderEmpty()) {
            receiptGenerator.generateReceipt(orderManager.getOrder(), totalCalculator.calculateTotal(orderManager.getOrder()));
            System.out.println("Загальна сума після знижок: " +
                    discountCalculator.calculateDiscount(totalCalculator.calculateTotal(orderManager.getOrder())) + " грн");
        }

    }
}
