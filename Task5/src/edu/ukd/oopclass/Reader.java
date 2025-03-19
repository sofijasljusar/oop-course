package edu.ukd.oopclass;

import java.util.ArrayList;

public class Reader {
    private String name;
    private ArrayList<Book> borrowedBooks;

    public Reader(String name) {
        this.name = name;
        this.borrowedBooks = new ArrayList<Book>();
    }

    public String getName() {
        return name;
    }

    public void borrow(Book book) {
        borrowedBooks.add(book);
    }

}
