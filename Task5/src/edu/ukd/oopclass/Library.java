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

    public Book findBook(String title, Author author) {
        for (Book book : books) {
            if (book.getTitle().equals(title) && book.getAuthor().equals(author)) {
                return book;
            }
        }
        return null;
    }

    public void addBook(String title, Author author, int year, String annotation) {
        Book existingBook = findBook(title, author);
        if (existingBook != null) {
                System.out.println("Книга вже є в бібліотеці ⬇");
                System.out.println(existingBook.getInfo());
                return;
            }
        Book newBook = new Book(title, author, year, annotation);  // with annotation
        books.add(newBook);
        System.out.println("Книга додана до бібліотеки: " + title);
    }

    public void addBook(String title, Author author, int year) {
        addBook(title, author, year, ""); // empty annotation
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

    public void borrowBookToReader(String title, Author author, Reader reader) {
        Book bookToBorrow = findBook(title, author);
        if (bookToBorrow != null) {
            if (!readerIsRegistered(reader)) {
                System.out.println("Незареєстрований читач не може позичати книги.");
            } else if (bookToBorrow.isBorrowed()) {
                System.out.println("Вибачте, наразі книга відсутня.");
            } else {
                reader.borrow(bookToBorrow);
                bookToBorrow.setBorrowed(true);
                System.out.println("Книгу '" + title + "' позичив " + reader.getName() + ".");
            }
        } else {
            System.out.println("Книгу не знайдено в бібліотеці.");
        }

    }

    public int getNumberOfReaders() {
        return readers.size();
    }

    private boolean readerIsRegistered(Reader reader) {
        return readers.contains(reader);
    }

    public void removeBook(String title, Author author) {
       Book bookToRemove = findBook(title, author);
        if (bookToRemove != null) {
            books.remove(bookToRemove);
            System.out.println("Книга '" + title + "' видалена з бібліотеки.");
        } else {
            System.out.println("Книга не знайдена в бібліотеці!");
        }
    }

    public int getBookCount() {
        return books.size();
    }

}
