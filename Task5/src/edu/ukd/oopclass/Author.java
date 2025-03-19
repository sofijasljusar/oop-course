package edu.ukd.oopclass;

public class Author {
    private final String name;
    private final int birthYear;

    public Author(String name, int birthYear) {
        this.name = name;
        this.birthYear = birthYear;
    }

    public String getInfo() {
        return "Ім'я: " + name + ", Рік народження: " + birthYear + ".";
    }

    public String getName() {
        return name;
    }



}
