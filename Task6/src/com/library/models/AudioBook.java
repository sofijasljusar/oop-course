package com.library.models;

public class AudioBook extends Multimedia{
    private int durationInSeconds;

    public AudioBook(String title, String language, int durationInSeconds) {
        super(title, language);
        this.durationInSeconds = durationInSeconds;
    }

    public int getdurationInSeconds() {
        return durationInSeconds;
    }

    public String getFormattedDuration() {
        int hours = durationInSeconds / 3600;
        int minutes = (durationInSeconds % 3600) / 60;
        int seconds = durationInSeconds % 60;

        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

    @Override
    public String toString() {
        return structureInfo("АУДІОКНИГУ",
                "Мова: " + getLanguage() +
                        "\nТривалість: " + getFormattedDuration());
    }

}

