package edu.ukd.oopclass;

public class Ship extends Transport{
    private String purpose;

    public Ship(String brand, String model, int year, String purpose) {
        super(brand, model, year);
        this.purpose = purpose;
    }

    public String getPurpose() {
        return this.purpose;
    }

    @Override
    public String getInfo() {
        return super.getInfo() + ", Purpose: " + purpose;
    }

    @Override
    public void move() {
        System.out.println("Ship is sailing...");
    }

}
