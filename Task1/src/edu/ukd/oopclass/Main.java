package edu.ukd.oopclass;

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("The Art of Computer Programming", "Donald E. Knuth", 1968, 672, "Technology");
        Book book2 = new Book("Design Patterns", "Gang of Four", 1994, 395, "Technology");
        Book book3 = new Book("Chip War", "Chris Miller", 2022, 500, "History");
        Book book4 = new Book("Extreme Programming Explained", "Kent Beck", 1999, 288, "Business");
        Book book5 = new Book("The Mythical Man-Month: Essays on Software Engineering", "Frederick P. Brooks", 1975, 332, "Business");

        System.out.printf("Книга '%s' є сучасною: %b \n", book1.getTitle(), book1.isModern());
        System.out.printf("Книга '%s' є сучасною: %b \n", book3.getTitle(), book3.isModern());


        System.out.printf("Книга '%s' належить жанру 'History': %b \n", book1.getTitle(), book1.belongsToGenre("History"));
        System.out.printf("Книга '%s' належить жанру 'Business': %b \n", book5.getTitle(), book5.belongsToGenre("Business"));


        Library library = new Library(new Book[]{book1, book2, book3, book4, book5});

        System.out.println(library.findBookByTitle("Absent edu.ukd.oopclass.Book"));
        System.out.println(library.findBookByTitle("Design Patterns"));

        System.out.println(library.compareBooksByPages(book5, book4));

    }
}
