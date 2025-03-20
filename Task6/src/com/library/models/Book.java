package com.library.models;


public class Book extends Material{
    private Author author;  // aggregates author
    private int year;

    public Book(String title, Author author, int year) {
        super(title);
        this.author = author;
        this.year = year;
    }

    public Author getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return structureInfo("КНИГУ",
                "Автор: " + author.getName() +
                        "\nРік: " + year
        );
    }
}
