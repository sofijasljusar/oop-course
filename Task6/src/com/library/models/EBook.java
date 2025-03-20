package com.library.models;

public class EBook extends Book {
    private String format;
    private double sizeInMegabytes;

    public EBook(String title, Author author, int year, String format, double sizeInMegabytes) {
        super(title, author, year);
        this.format = format;
        this.sizeInMegabytes = sizeInMegabytes;
    }

    @Override
    public String toString() {
        return structureInfo("ЕЛЕКТРОННУ КНИГУ",
                "Автор: " + getAuthor().getName() +
                        "\nРік: " + getYear() +
                        "\nФормат: " + format +
                        "\nРозмір: " + sizeInMegabytes + " MB");

    }
}
