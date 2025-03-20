package com.library.models;

public abstract class Multimedia extends Material{
    private String language;

    public Multimedia(String title, String language) {
        super(title);
        this.language = language;
    }

    public String getLanguage() {
        return language;
    }

}
