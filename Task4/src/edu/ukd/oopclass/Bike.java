package edu.ukd.oopclass;

public class Bike extends Transport{
    private int engineVolume;

    public Bike(String brand, String model, int year, int engineVolume) {
        super(brand, model, year);
        this.engineVolume = engineVolume;
    }

    public int getEngineVolume() {
        return this.engineVolume;
    }

    @Override
    public String getInfo() {
        return super.getInfo() + ", Engine volume: " + engineVolume + " cc";
    }

    @Override
    public void move() {
        System.out.println("Bike is speeding...");
    }

}
