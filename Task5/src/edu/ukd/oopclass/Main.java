package edu.ukd.oopclass;
import java.util.ArrayList;

public class Main {
    public static void main (String[] args) {

        Author author1 = new Author("Джордж Оруелл", 1903);
        Author author2 = new Author("Рей Бредбері", 1920);
        Author author3 = new Author("Франц Кафка", 1883);


        Book book1 = new Book("1984", author1, 1949);
        Book book2 = new Book("Дорога до світанку", author1, 1950, "Піднесення над темрявою деспотизму.");
        Book book3 = new Book("Відповідальність", author1, 1955, "Погляд на роль особистої відповідальності в суспільстві.");
        Book book4 = new Book("Останні дні імперії", author1, 1975, "Прогнози про падіння імперій та їхній вплив на людей.");
        Book book5 = new Book("451° за Фаренгейтом", author2, 1953, "Світ, у якому заборонено книги.");
        Book book6 = new Book("Америка", author3, 1927, "Роман про життя емігранта, який шукає своє місце в Америці.");
        Book book7 = new Book("Вибір", author3, 1923, "Про важливість вибору та внутрішні суперечності людини.");
        Book book8 = new Book("Ніч", author3, 1921, "Про суть людської психології через символи і сновидіння.");
        Book book9 = new Book("Молитва", author3, 1929, "Ідеї про силу віри і її взаємодію з реальним світом.");
        Book book10 = new Book("Молитва", author3, 1929, "Ідеї про силу віри і її взаємодію з реальним світом.");


        System.out.println("\nІнформація про автора: ");
        System.out.println(author1.getInfo());
        System.out.println("\nІнформація про книгу: ");
        System.out.println(book3.getInfo());

        Library library1 = new Library("Міська бібліотека");
        System.out.println("\nСтворено бібліотеку: " + library1.getName());

        library1.addBook(book1);
        library1.addBook(book2);
        library1.addBook(book3);
        library1.addBook(book4);
        library1.addBook(book5);
        library1.addBook(book6);
        library1.addBook(book7);
        library1.addBook(book8);
        library1.addBook(book9);
        library1.addBook(book9);
        library1.addBook(book10);

        System.out.println("\nУСІ КНИГИ В БІБЛІОТЕЦІ");
        for (Book book: library1.listBooks()) {
            System.out.println(book.getInfo() + "\n");
        }

        System.out.println("\nУСІ КНИГИ АВТОРА");
        for (Book book: library1.findBooksByAuthor(author3)) {
            System.out.println(book.getInfo() + "\n");
        }

        Reader anatolyi = new Reader("Анатолій");
        Reader tolik = new Reader("Толік");

        System.out.println("Кількість читачів до Анатолія: " + library1.getNumberOfReaders());
        library1.registerReader(anatolyi);
        System.out.println("Кількість читачів після Анатолія: " + library1.getNumberOfReaders());

        library1.borrowBookToReader(book1, tolik);
        library1.borrowBookToReader(book1, anatolyi);
        library1.borrowBookToReader(book1, anatolyi);

        System.out.println("\nПОШУК КНИГ ЗА РОКОМ");
        ArrayList<Book> booksFound = library1.findBooksByYear(1949);
        if (booksFound.isEmpty()) {
            System.out.println("Немає книг за вказаний рік.");
        } else {
            for (Book book : booksFound) {
                System.out.println(book.getInfo() + "\n");
            }
        }

        System.out.println("Кількість книг до: " + library1.getBookCount());
        library1.removeBook(book1);
        System.out.println("Кількість книг після: " + library1.getBookCount());


        book1 = null;
        System.out.println("\nКнигу було видалено.");
        System.out.println("Автор після видалення книги:\n" + author1.getInfo());


        library1 = null;
        System.out.println("Бібліотеку було видалено.");
        System.out.println("Книги після видалення бібліотеки:\n" + author1.getInfo());

        if (library1 != null) {
            library1.listBooks();
        } else {
            System.out.println("Бібліотека більше не існує, книги видалено.");
        }

    }
}
