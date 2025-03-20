package com.library.models;

public class DVD extends Multimedia{
    private String format;

    public DVD(String title, String language, String format) {
        super(title, language);
        this.format = format;
    }

    public String getFormat() {
        return format;
    }

    @Override
    public String toString() {
        return structureInfo("DVD",
                "Мова: " + getLanguage() +
                        "\nФормат: " + format);
    }

}

