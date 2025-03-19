package edu.ukd.oopclass;

public class Book {
    private String title;
    private Author author;
    private int year;
    private String annotation;
    private boolean borrowed;

    public Book(String title, Author author, int year, String annotation) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.annotation = annotation;
        this.borrowed = false;
    }

    public Book(String title, Author author, int year) {
        this(title, author, year, "");
    }

    public String getInfo() {
        return "Назва: " + title +
                ", Рік видання: " + year +
                ", Автор: " + author.getName() + "." +
                (annotation.isEmpty() ? "" : "\nАнотація: " + annotation);
    }

    public Author getAuthor() {
        return this.author;
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }
}
