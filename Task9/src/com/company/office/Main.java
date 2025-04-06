package com.company.office;

public class Main {
    public static void main(String[] args) {
        Employee organization = new Department("Компанія 'Два Відра'");

        Employee employee1 = new IndividualEmployee("Степаненко Степан", "маркетолог");
        Employee employee2 = new IndividualEmployee("Тарасенко Тарас", "візажист");
        Employee employee3 = new IndividualEmployee("Василенко Василь", "нотаріус");
        Employee employee4 = new IndividualEmployee("Петренко Петро", "office-manager");
        Employee employee5 = new IndividualEmployee("Романюк Роман", "оперативник");
        Employee employee6 = new IndividualEmployee("Григорян Григорій", "фрілансер");
        Employee employee7 = new IndividualEmployee("Григорян Григорій", "імпостер");


        Employee department1 = new Department("Офіс");
        Employee department2 = new Department("Маркетингу");
        Employee department3 = new Department("Юридичний");

        organization.add(department1);
        organization.add(department1);
        organization.add(department2);
        organization.add(department3);

        department1.add(employee2);
        department1.remove(employee4);
        department1.add(employee4);

        department2.add(employee1);

        department3.add(employee3);
        department3.add(employee5);

        organization.add(employee6);
        organization.add(employee7);


        System.out.println(organization.getInfo());

        System.out.println("Кількість працівників у компанії:");
        System.out.println(organization.calculateEmployees());

        System.out.println("Новий тип працівника:");
        Employee manager = new Manager("Михайлюк Михайло");
        Employee employee8 = new IndividualEmployee("Костишин Констянтин", "заступник менеджера");
        Employee employee9 = new IndividualEmployee("Олекса Олексій", "зам-зама");
        manager.add(employee8);
        manager.add(employee9);
        System.out.println(manager.getInfo());

        System.out.println("Пошук працівника:");
        organization.findByName("Романюк Роман")
                .ifPresentOrElse(
                        employee -> System.out.println("Знайдено ✅\n" + employee.getInfo()),
                        () -> System.out.println("Співробітника не знайдено ❌")
                );



    }
}
