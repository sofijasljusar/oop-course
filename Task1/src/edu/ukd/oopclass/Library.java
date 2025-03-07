package edu.ukd.oopclass;

public class Library {
    private Book[] books;

    public Library(Book[] books) {
        this.books = books;
    }

    public String findBookByTitle(String title) {
        for (Book book: books) {
            if (book.getTitle().equals(title)) {
                return "✅ Знайдено книгу: " + book.getInfo();
            }
        }
        return String.format("⛔️Книгу %s не знайдено", title);

    }

    public String compareBooksByPages(Book book1, Book book2) {
        if (book1.getPages() > book2.getPages()) {
            return String.format("Книга '%s' має більше сторінок.", book1.getTitle());
        } else if (book1.getPages() < book2.getPages()) {
            return String.format("Книга '%s' має більше сторінок.", book2.getTitle());
        } else {
            return "Кількість сторінок у книжках однакова.";
        }
    }
}
