package com.library.models;

public class Guest extends Reader {

    public Guest(String name, String phoneNumber) {
        super(name, phoneNumber);
    }

    @Override
    protected void setborrowedMaterialsLimit() {
        this.borrowedMaterialsLimit = 2;
    }

    @Override
    protected void setReturnInWeeksLimit() {
        this.returnInWeeksLimit = 1;
    }

}
