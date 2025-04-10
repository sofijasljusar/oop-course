package com.company.office;

// Improvements: for simple structure can be simply Composite with abstract methods from employee,
// and manager would be individual employee

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public interface Employee {

    default void add(Employee employee) {
        System.out.println("ПОМИЛКА: Метод add() не підтримується для окремого працівника.");
    }

    default void remove(Employee employee) {
        System.out.println("ПОМИЛКА: Метод remove() не підтримується для окремого працівника.");
    }

    default List<Employee> getEmployeesList() {
        return Collections.emptyList();
    }

    String getInfo();

    default int calculateEmployees() {
        return 1;
    }

    Optional<Employee> findByName(String name);

}
