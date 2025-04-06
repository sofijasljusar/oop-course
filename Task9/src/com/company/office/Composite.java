package com.company.office;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public abstract class Composite implements Employee{
    private final String name;
    private final String position;
    private List<Employee> employeesList = new ArrayList<>();


    public Composite(String name, String position) {
        this.name = name;
        this.position = position;
    }


    @Override
    public void add(Employee employee) {
        if (employeesList.contains(employee)) {
            System.out.println("Працівника/відділ вже було додано!");
        } else {
            employeesList.add(employee);
        }

    }

    @Override
    public void remove(Employee employee) {
        employeesList.remove(employee);
    }

    @Override
    public List<Employee> getEmployeesList() {
        return employeesList;
    }

    @Override
    public String getInfo() {
        StringBuilder infoString =
                new StringBuilder(
                        "--------------------------------------------------\n" +
                                position + " " + name + ":");

        for (final Employee employee: employeesList) {
            infoString.append("\n").append(employee.getInfo());
        }
        infoString.append("\n--------------------------------------------------");

        return infoString.toString();
    }

    @Override
    public int calculateEmployees() {
        int count = 0;
        for (Employee employee : employeesList) {
            count += employee.calculateEmployees();
        }
        return count;
    }

    @Override
    public Optional<Employee> findByName(String name) {
        if (this.name.equalsIgnoreCase(name)) return Optional.of(this);

        for (Employee employee : employeesList) {
            Optional<Employee> found = employee.findByName(name);
            if (found.isPresent()) {
                return found;
            }
        }

        return Optional.empty();

    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Composite composite = (Composite) o;
        return Objects.equals(name, composite.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
