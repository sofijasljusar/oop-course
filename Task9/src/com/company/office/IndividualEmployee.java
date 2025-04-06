package com.company.office;

import java.util.Objects;
import java.util.Optional;

public class IndividualEmployee implements Employee{
    private final String name;
    private final String position;

    public IndividualEmployee(String name, String position) {
        this.name = name;
        this.position = position;
    }

    @Override
    public String getInfo() {
        return String.format("Працівник: %s, %s", name, position);
    }

    @Override
    public Optional<Employee> findByName(String name) {
        return this.name.equalsIgnoreCase(name) ? Optional.of(this) : Optional.empty();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        IndividualEmployee that = (IndividualEmployee) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
