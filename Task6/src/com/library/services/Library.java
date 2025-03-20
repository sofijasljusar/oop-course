package com.library.services;
import com.library.models.Material;

import java.util.ArrayList;

public class Library {
    private String name;
    private String address;
    private int yearFound;
    private ArrayList<Department> departments; // aggregates departments


    public Library(String name, String address, int yearFound) {
        this.name = name;
        this.address = address;
        this.yearFound = yearFound;
        this.departments = new ArrayList<Department>();
    }

    public void addDepartment(Department department) {
        if (departments.contains(department)) {
            System.out.println("\nВідділ '" + department.getName() + "' вже існує!");
        } else {
            departments.add(department);
            System.out.println("\nДодано відділ '" + department.getName() + "'");
        }
    }

    public void removeDepartment(Department department) {
        if (departments.contains(department)) {
            departments.remove(department);
            System.out.println("\nВидалено відділ '" + department.getName() + "'");
        } else {
            System.out.println("\nВідділ '" + department.getName() + "' не знайдено у цій бібліотеці!");
        }
    }

    public void addMaterialToDepartment(Department department, Material material) {
        if (departments.contains(department)) {
            department.addMaterial(material);
        } else {
            System.out.println("\nВідділ '" + department.getName() + "' не знайдено у цій бібліотеці!");
        }

    }

    public void removeMaterialFromDepartment(Department department, Material material) {
        if (departments.contains(department)) {
            department.removeMaterial(material);
        } else {
            System.out.println("\nВідділ '" + department.getName() + "' не знайдено у цій бібліотеці!");
        }
    }

    @Override
    public String toString() {

        StringBuilder libraryString =
                new StringBuilder("\nІНФОРМАЦІЯ ПРО БІБЛІОТЕКУ" +
                        "\nБібліотека: " + name +
                        "\nАдреса: " + address +
                        "\nЗасновано: " + yearFound +
                        "\nВідділи:");

        for (Department department: departments) {
            libraryString.append("\n        -").append(department.getName());
        }

        return libraryString.toString();
    }



}
