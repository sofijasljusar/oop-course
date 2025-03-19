package edu.ukd.oopclass;

public class Car implements AutoCloseable{
    public String brand;
    public String model;
    public int year;
    public double mileage;

    // Classic constructor
    public Car() {
        System.out.println(getInfo());
        brand = "Unknown";
        model = "Unknown";
        year = 0;
        mileage = 0;
    }

    // Parameterized constructor
    public Car(String brand, String model, int year, double mileage) {
        if (year > java.time.Year.now().getValue()) {
            System.out.println("Year cannot be in the future. CAR NOT CREATED");
        } else {
            this.brand = brand;
            this.model = model;
            this.year = year;
            this.mileage = mileage;
        }
    }
//
//    public Car(Car another) {
//        this(another.brand, another.model+"-copy", another.year, another.mileage);
//    }

    public String getInfo() {
        return "Марка: " + brand + ", Модель: " + model + ", Рік: " + year + ", Пробіг: " + mileage + " км";
    }

    @Override
    public void close() {
        System.out.println("Автомобіль " + brand + " " + model + " видалено з пам'яті.");
    }

    public void updateMileage(double newMileage) {
        if (newMileage > mileage) {
            mileage = newMileage;
            System.out.println("Mileage updated successfully.");

        } else {
            System.out.println("New mileage should be greater than the previous. MILEAGE NOT UPDATED.");
        }
    }
    public String compareByYear(Car comparisonCar) {
        if (year < comparisonCar.year) {
            return model + " has earlier manufacture year than " + comparisonCar.model;
        } else if (year > comparisonCar.year) {
            return model + " has later manufacture year than " + comparisonCar.model;
        } else {
            return model + " and " + comparisonCar.model + " have the same manufacture year.";
        }
    }


}
