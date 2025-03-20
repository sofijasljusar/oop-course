package com.library.models;

public class Employee extends Reader{

    public Employee(String name, String phoneNumber) {
        super(name, phoneNumber);
    }

    @Override
    protected void setborrowedMaterialsLimit() {
        this.borrowedMaterialsLimit = 100;
    }

    @Override
    protected void setReturnInWeeksLimit() {
        this.returnInWeeksLimit = 100;
    }

}
