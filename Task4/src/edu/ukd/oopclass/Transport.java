package edu.ukd.oopclass;

import java.util.Objects;

public abstract class Transport {
    public static int COUNTER = 0;
    static {
        System.out.println("Static in Transport");
    }

    public Transport(String brand, String model, int year) {
        System.out.println("Transport Constructor");
        this.brand = brand;
        this.model = model;
        this.year = year;

    }

    public String getInfo() {
        return "Brand: " + brand + ", Model: " + model + ", Year: " + year;
    }

    public abstract void move();



    private String brand;
    private String model;
    private int year;


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Transport transport = (Transport) o;
        return year == transport.year && Objects.equals(brand, transport.brand) && Objects.equals(model, transport.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, year);
    }

}
