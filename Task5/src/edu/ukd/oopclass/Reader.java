package edu.ukd.oopclass;

import java.util.ArrayList;

public class Reader {
    private String name;
    private ArrayList<Book> borrowedBooks = new ArrayList<>();

    public Reader(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void borrow(Book book) {
        borrowedBooks.add(book);
    }

}
