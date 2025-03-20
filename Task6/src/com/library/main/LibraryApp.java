package com.library.main;
import com.library.models.*;
import com.library.services.Library;
import com.library.services.Department;


public class LibraryApp {
    public static void main(String[] args) {
        Library library = new Library("Обласна бібліотека", "вул. Чорновола, 22", 1940);

        Department department1 = new Department("Філософія");
        Department department2 = new Department("Історія");
        Department department3 = new Department("Мистецтво");
        Department department4 = new Department("Література");
        Department department5 = new Department("Наука");

        library.addDepartment(department1);
        library.addDepartment(department2);
        library.addDepartment(department3);
        library.addDepartment(department4);
        library.addDepartment(department5);

        library.removeDepartment(department3);
        System.out.println("Департамент існує незалежно від бібліотеки");
        System.out.println(department3);

        Author author1 = new Author("Іммануїл", "Кант", "22.04.1724");
        Author author2 = new Author("Михайло", "Грушевський", "29.09.1866"); // Український історик
        Author author3 = new Author("Леся", "Українка", "25.02.1871");

        Book book1 = new Book("Критика чистого розуму", author1, 1781);
        Book book2 = new Book("Нарис історії українського народу", author2, 1904);
        Book book3 = new Book("Ілюстрована історія України", author2, 1911);
        Book book4 = new Book("Українська історіографія", author2, 1923);
        Book book5 = new Book("Лісова пісня", author3, 1911);
        Book book6 = new Book("Кассандра", author3, 1907);

        department1.addMaterial(book1);
        department2.addMaterial(book2);
        department2.addMaterial(book3);
        department2.addMaterial(book4);
        department2.addMaterial(book4);
        department3.addMaterial(book5);
        department3.addMaterial(book6);

        System.out.println(library);
        System.out.println(department2);
        department2.removeMaterial(book3);
        department2.removeMaterial(book6);
        System.out.println(department2);

        Book book7 = new Book("Основи метафізики моральності", author1, 1785);
        Book book8 = new Book("Природна історія та теорія неба", author1, 1755);
        library.addMaterialToDepartment(department1, book7);
        library.addMaterialToDepartment(department1, book8);
        System.out.println(department1);
        library.removeMaterialFromDepartment(department1, book7);
        System.out.println(department1);

        Author kevinMitnick = new Author("Кевін", "Мітнік", "06.08.1963");
        EBook ebook = new EBook("Мистецтво обману", kevinMitnick, 2002, "pdf", 1.5);
        System.out.println(ebook);
        System.out.println(book1);

        Reader student = new Student("Студент Олександр", "123-456-789");
        Reader employee = new Employee("Працівниця Анастасія", "987-654-321");
        Reader guest = new Guest("Гість Степан", "555-666-777");

        student.borrow(book1);
        employee.borrow(book2);
        guest.borrow(book4);
        guest.borrow(book5);
        guest.borrow(book6);
        System.out.println(student);
        System.out.println(employee);
        System.out.println(guest);


        book1.addRating("amelie", 4, "ahahahh");
        book1.addRating("emerald", 4, "ehehehe");
        book1.addRating("santa", 5, "hohoho");
        book1.addRating("monica", 5, "hzhhzhzh");

        System.out.println(book1);

        Newspaper newspaper = new Newspaper("Щоденні новини", 101, "20.03.2025", "Ґанок");
        System.out.println(newspaper);

        Journal journal = new Journal("Теревені", 42, "20.03.2025", "Плітки");
        System.out.println(journal);

        DVD dvd = new DVD("Диск", "Українська", "audio");
        System.out.println(dvd);

        AudioBook audioBook = new AudioBook("Найбагатший чоловік у Вавилоні", "Англійська", 5415);
        System.out.println(audioBook);

    }


}
