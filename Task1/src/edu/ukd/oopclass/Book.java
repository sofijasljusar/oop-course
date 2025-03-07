package edu.ukd.oopclass;

public class Book {
    private final String title;
    private final String author;
    private final int year;
    private final int pages;
    private final String genre;

    Book(String title, String author, int year, int pages, String genre) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.pages = pages;
        this.genre = genre;
    }

    public String getTitle() {
        return this.title;
    }

    public int getPages() {
        return this.pages;
    }

    public String getInfo() {
        return String.format("Назва: '%s', Автор: %s, Рік видання: %d, Сторінок: %d.",
                this.title, this.author, this.year, this.pages);
    }

    public boolean isModern() {
        return this.year > 2010;
    }

    public boolean belongsToGenre(String genre) {
        return this.genre.equals(genre);
    }
}

