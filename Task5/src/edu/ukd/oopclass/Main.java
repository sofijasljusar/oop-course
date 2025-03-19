package edu.ukd.oopclass;
import java.util.ArrayList;

public class Main {
    public static void main (String[] args) {

        Author author1 = new Author("Джордж Оруелл", 1903);
        Author author2 = new Author("Рей Бредбері", 1920);
        Author author3 = new Author("Франц Кафка", 1883);

        System.out.println("\nІнформація про автора 1: ");
        System.out.println(author1.getInfo());
        System.out.println("\nІнформація про автора 2: ");
        System.out.println(author2.getInfo());
        System.out.println("\nІнформація про автора 3: ");
        System.out.println(author3.getInfo());


        Library library1 = new Library("Міська бібліотека");
        System.out.println("\nСтворено бібліотеку: " + library1.getName());

        library1.addBook("1984", author1, 1949);
        library1.addBook("Дорога до світанку", author1, 1950, "Піднесення над темрявою деспотизму.");
        library1.addBook("Відповідальність", author1, 1955, "Погляд на роль особистої відповідальності в суспільстві.");
        library1.addBook("Останні дні імперії", author1, 1975, "Прогнози про падіння імперій та їхній вплив на людей.");
        library1.addBook("451° за Фаренгейтом", author2, 1953, "Світ, у якому заборонено книги.");
        library1.addBook("Америка", author3, 1927, "Роман про життя емігранта, який шукає своє місце в Америці.");
        library1.addBook("Вибір", author3, 1923, "Про важливість вибору та внутрішні суперечності людини.");
        library1.addBook("Ніч", author3, 1921, "Про суть людської психології через символи і сновидіння.");
        library1.addBook("Молитва", author3, 1929, "Ідеї про силу віри і її взаємодію з реальним світом.");
        library1.addBook("Молитва", author3, 1929, "Ідеї про силу віри і її взаємодію з реальним світом.");

        System.out.println("\nУСІ КНИГИ В БІБЛІОТЕЦІ");
        for (Book book: library1.listBooks()) {
            System.out.println(book.getInfo() + "\n");
        }

        System.out.println("\nУСІ КНИГИ АВТОРА");
        for (Book book: library1.findBooksByAuthor(author3)) {
            System.out.println(book.getInfo() + "\n");
        }

        System.out.println("\nПОШУК КНИГ ЗА РОКОМ");
        ArrayList<Book> booksFound = library1.findBooksByYear(1949);
        if (booksFound.isEmpty()) {
            System.out.println("Немає книг за вказаний рік.");
        } else {
            for (Book book : booksFound) {
                System.out.println(book.getInfo() + "\n");
            }
        }


        Reader anatolyi = new Reader("Анатолій");
        Reader tolik = new Reader("Толік");

        System.out.println("Кількість читачів до Анатолія: " + library1.getNumberOfReaders());
        library1.registerReader(anatolyi);
        System.out.println("Кількість читачів після Анатолія: " + library1.getNumberOfReaders());

        library1.borrowBookToReader("Америка", author3, tolik);
        library1.borrowBookToReader("Америка", author3, anatolyi);
        library1.borrowBookToReader("Америка", author3, anatolyi);
        library1.borrowBookToReader("Норвегія", author3, anatolyi);


        System.out.println("\nКількість книг до: " + library1.getBookCount());
        library1.removeBook("Ніч", author3);
        System.out.println("Кількість книг після: " + library1.getBookCount());
        System.out.println("Автор після видалення книги ⬇\n" + author3.getInfo());

        // Simulate library deletion
        library1 = null;
        System.out.println("\nБібліотеку було видалено.");
        System.out.println("Книги після видалення бібліотеки:\n");

        if (library1 != null) {
            library1.listBooks();
        } else {
            System.out.println("Бібліотека більше не існує, книги видалено.");
        }

    }
}
