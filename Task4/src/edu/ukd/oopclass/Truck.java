package edu.ukd.oopclass;

public class Truck extends Transport{
    private int cargoCapacity;

    public Truck(String brand, String model, int year, int cargoCapacity) {
        super(brand, model, year);
        this.cargoCapacity = cargoCapacity;
    }

    public int getCargoCapacity() {
        return this.cargoCapacity;
    }

    @Override
    public String getInfo() {
        return super.getInfo() + ", Cargo capacity: " + cargoCapacity + " tons";
    }

    @Override
    public void move() {
        System.out.println("Truck is delivering packages...");
    }

}
