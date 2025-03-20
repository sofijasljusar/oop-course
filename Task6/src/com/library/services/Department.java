package com.library.services;
import com.library.models.Material;

import java.util.ArrayList;


public class Department {
    private String name;
    private ArrayList<Material> materials = new ArrayList<>();;  // aggregates materials


    public Department(String name) {
        this.name = name;
    }


    public void addMaterial(Material material) {
        if (materials.contains(material)) {
            System.out.println("\nКнига '" + material.getTitle() + "' вже наявна у цьому відділі!");
        } else {
            materials.add(material);
            System.out.println("\nДодано книгу '" + material.getTitle() + "'");
        }

    }

    public void removeMaterial(Material material) {
        if (materials.contains(material)) {
            materials.remove(material);
            System.out.println("\nВидалено книгу '" + material.getTitle() + "'");
        } else {
            System.out.println("\nКнига '" + material.getTitle() + "' не знайдена у відділі '" +name+ "'!");
        }
    }

    @Override
    public String toString() {
        StringBuilder departmentString =
                new StringBuilder("\nІНФОРМАЦІЯ ПРО ВІДДІЛ" +
                        "\nВідділ: " + name +
                        "\nКниги: ");
        if (materials.isEmpty()) {
            departmentString.append("Книги відсутні");
        } else {
            for (Material material: materials) {
                departmentString.append("\n        ").append(material.getTitle());
            }
        }
        return departmentString.toString();

    }

    public String getName() {
        return name;
    }
}
