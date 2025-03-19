package edu.ukd.oopclass;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        Car classicCar = new Car();
        Car parameterCar1 = new Car("LAZ", "LAZ-697", 1959, 500_000);
//        Car car3 = new Car(classicCar);

        System.out.println(classicCar.getInfo());






//        System.out.println("\n----------Test classic constructor----------");
//        Car classicCar = new Car();
//        System.out.println(classicCar.getInfo());
//
//        System.out.println("\n----------Test parameterized constructor----------");
//        Car parameterCar1 = new Car("LAZ", "LAZ-697", 1959, 500_000);
//        Car parameterCar2 = new Car("Cherkasy", "Bohdan", 1992, 100_000);
//
//        System.out.println(parameterCar1.getInfo());
//
//        System.out.println("\n----------Test copy constructor----------");
//        Car carCopy = new Car(parameterCar1);
//        System.out.println(carCopy.getInfo());
//
//        System.out.println("\n----------Test destructor----------");
//        try (Car car = new Car("Chernihiv Bus Plant", "ASC-03", 1976, 200_000)) {
//            System.out.println(car.getInfo());
//        }
//
//        System.out.println("\n----------Test updating mileage----------");
//        classicCar.updateMileage(200);
//        System.out.println(classicCar.getInfo());
//        classicCar.updateMileage(100);
//        System.out.println(classicCar.getInfo());
//
//        System.out.println("\n----------Test creating car with manufacture year in the future----------");
//        Car futureCar = new Car("NASA", "Space Cruiser 7000", 3000, 0);
//
//        System.out.println("\n----------Test comparing by year----------");
//        System.out.println(parameterCar1.compareByYear(parameterCar2));
//        System.out.println(parameterCar2.compareByYear(parameterCar1));
//        System.out.println(parameterCar1.compareByYear(carCopy));

    }
}
