package com.library.models;

public class Student extends Reader{

    public Student(String name, String phoneNumber) {
        super(name, phoneNumber);
    }

    @Override
    protected void setborrowedMaterialsLimit() {
        this.borrowedMaterialsLimit = 10;
    }

    @Override
    protected void setReturnInWeeksLimit() {
        this.returnInWeeksLimit = 8;
    }

}
