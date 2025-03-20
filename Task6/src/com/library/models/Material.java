package com.library.models;

import java.util.ArrayList;

public abstract class Material {
    private String title;
    private ArrayList<Rating> ratings = new ArrayList<>(); // composition!


    public Material(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void addRating(String nickname, int stars, String review) {
        Rating newRating = new Rating(nickname, stars, review);
        ratings.add(newRating);
    }

    protected String structureInfo(String about, String additionalInfo) {
        StringBuilder basicString = new StringBuilder(
                "\nІНФОРМАЦІЯ ПРО " + about +
                "\nНазва: " + title +
                "\n" + additionalInfo +
                "\nВідгуки: ");
        if (ratings.isEmpty()) {
            basicString.append("немає");
        } else {
            basicString.append("\n        -cередня оцінка: ").append(getAverageRating());
            for (Rating rating: ratings) {
                basicString.append("\n        -").append(rating);
            }
        }
        return basicString.toString();
    }

    public double getAverageRating() {
        if (ratings.isEmpty()) {
            return 0;
        }
        double sum = 0;
        for (Rating rating: ratings) {
            sum += rating.getStars();
        }
        return sum/ratings.size();
    }

}
