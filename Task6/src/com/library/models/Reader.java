package com.library.models;

import java.util.ArrayList;

public abstract class Reader {
    private String name;
    private String phoneNumber;
    private ArrayList<Material> borrowedMaterials = new ArrayList<>();
    protected int borrowedMaterialsLimit;
    protected int returnInWeeksLimit;

    public Reader(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        setborrowedMaterialsLimit();
        setReturnInWeeksLimit();
    }

    public String getName() {
        return name;
    }

    protected abstract void setborrowedMaterialsLimit();

    protected abstract void setReturnInWeeksLimit();

    public void borrow(Material material) {
        if (borrowedMaterials.size() == borrowedMaterialsLimit) {
            System.out.println(name + " не може взяти більше " + borrowedMaterialsLimit + " книг.");
        } else {
            borrowedMaterials.add(material);
            System.out.println(name + " взяв книгу: " + material.getTitle());
        }
    }

    @Override
    public String toString() {
        StringBuilder readerString =
                new StringBuilder("\nІНФОРМАЦІЯ ПРО ЧИТАЧА" +
                        "\nТип абонемента: " + this.getClass().getSimpleName() +
                        "\n* дозволяє позичити " + borrowedMaterialsLimit + " матеріалів" +
                        "\n* повернути через " + returnInWeeksLimit +
                        (returnInWeeksLimit == 1 ? " тиждень" : " тижнів") +
                        "\nІмʼя: " + name +
                        "\nНомер телефону: " + phoneNumber +
                        "\nКниги: ");
        if (borrowedMaterials.isEmpty()) {
            readerString.append("Читач не має книг");
        } else {
            for (Material material: borrowedMaterials) {
                readerString.append("\n        -").append(material.getTitle());
            }
        }
        return readerString.toString();
    }
}
