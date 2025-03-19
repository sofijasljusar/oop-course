package edu.ukd.oopclass;

public class Car extends Transport {

    public static String FAMILY = "CAR";

    private int passengerCapacity;

    static {
        System.out.println("Static in Car");
    }

    public Car(String brand, String model, int year, int passengerCount) {
        super(brand, model, year);
        System.out.println("Car Constructor");
        this.passengerCapacity = passengerCount;
    }

    public int getPassengerCapacity() {
        return this.passengerCapacity;
    }

    @Override
    public String getInfo() {
        return super.getInfo() + ", Passengers: " + passengerCapacity;
    }

    @Override
    public void move() {
        System.out.println("Car is riding...");
    }

}
