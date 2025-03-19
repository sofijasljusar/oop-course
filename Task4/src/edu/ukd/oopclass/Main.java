package edu.ukd.oopclass;

public class Main {
    public static void main (String[] args) {

        Car car = new Car("Chevrolet", "Bolt E", 2023, 5);

        System.out.println(car.toString());



//        System.out.println(Transport.COUNTER);
//        Truck truck = new Truck("Peterbilt", "379", 2005, 36);
//        System.out.println(Transport.COUNTER);
//        Bike bike = new Bike("Harley-Davidson", "Iron 883", 2023, 883);
//        System.out.println(Transport.COUNTER);
//        Ship ship = new Ship("Captain Jack Sparrow", "Black Pearl", 1700, "Pirate");
//        System.out.println(Transport.COUNTER);
//        Transport[] vehicles = {car, truck, bike, ship};
//
//        for (Transport vehicle : vehicles) {
//            if (vehicle instanceof Car) {
//                System.out.println("\nThis is a Car.");
//            } else if (vehicle instanceof Truck) {
//                System.out.println("\nThis is a Truck.");
//            } else if (vehicle instanceof Bike) {
//                System.out.println("\nThis is a Bike.");
//            } else if (vehicle instanceof Ship) {
//                System.out.println("\nThis is a Ship.");
//            }
//
//            System.out.println(vehicle.getInfo());
//            vehicle.move();
//        }

    }
}
