package com.library.models;

public class Rating {
    private String nickname;
    private int stars;
    private String review;

    public Rating(String nickname, int stars, String review) {
        this.nickname = nickname;
        this.stars = stars;
        this.review = review;
    }

    public Rating(String nickname, int stars) {
        this(nickname, stars, "");
    }

    @Override
    public String toString() {
        return String.format("Нік: %s | Оцінка: %d з 5 зірок | Опис: %s", nickname, stars, review.isEmpty() ? "Без відгуку" : review);
    }

    public int getStars() {
        return stars;
    }
}
