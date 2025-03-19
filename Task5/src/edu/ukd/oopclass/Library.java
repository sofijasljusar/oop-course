package edu.ukd.oopclass;

import java.util.ArrayList;
import java.util.Iterator;

public class Library {
    private String name;
    private ArrayList<Book> books;
    private ArrayList<Reader> readers;

    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<Book>();
        this.readers = new ArrayList<Reader>();
    }

    public String getName() {
        return name;
    }

    public void addBook(Book newBook) {
        for (Book existingBook: books) {
            if (existingBook.getTitle().equals(newBook.getTitle())
            && existingBook.getAuthor().equals(newBook.getAuthor())) {
                System.out.println("Книга вже є в бібліотеці!");
                return;
            }
        }
        books.add(newBook);
    }

    public ArrayList<Book> listBooks() {
        return books;
    }

    public ArrayList<Book> findBooksByAuthor(Author author) {
        ArrayList<Book> foundBooks = new ArrayList<>();
        for (Book book: books) {
            if (book.getAuthor().equals(author)) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    public ArrayList<Book> findBooksByYear(int year) {
        ArrayList<Book> foundBooks = new ArrayList<>();
        for (Book book: books) {
            if (book.getYear() == year) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    public void registerReader(Reader reader) {
        readers.add(reader);
    }

    public void borrowBookToReader(Book book, Reader reader) {
        if (!readerIsRegistered(reader)) {
            System.out.println("Незареєстрований читач не може позичати книги.");
        } else if (book.isBorrowed()) {
            System.out.println("Вибачте, наразі книга відсутня.");
        } else {
            reader.borrow(book);
            book.setBorrowed(true);
            System.out.println("Книгу '" + book.getTitle() + "' позичив " + reader.getName() + ".");
        }
    }

    public int getNumberOfReaders() {
        return readers.size();
    }

    private boolean readerIsRegistered(Reader reader) {
        return readers.contains(reader);
    }

    public void removeBook(Book book) {
        Iterator<Book> iterator = books.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals(book)) {
                iterator.remove();
                System.out.println("Книга видалена з бібліотеки.");
                return;
            }
        }
        System.out.println("Книга не знайдена в бібліотеці!");
    }

    public int getBookCount() {
        return books.size();
    }

}
