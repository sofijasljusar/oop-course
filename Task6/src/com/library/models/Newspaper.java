package com.library.models;

public class Newspaper extends Press{
    private String publisher;

    public Newspaper(String title, int issueNumber, String issueDate, String publisher) {
        super(title, issueNumber, issueDate);
        this.publisher =publisher;
    }

    public String getPublisher() {
        return publisher;
    }

    @Override
    public String toString() {
        return structureInfo("ГАЗЕТУ",
                "Номер випуску: " + getIssueNumber()+
                        "\nЧисло випуску: " + getIssueDate() +
                        "\nВидання: " + publisher);
    }

}
