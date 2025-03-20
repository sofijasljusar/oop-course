package com.library.models;

public abstract class Press extends Material{
    private int issueNumber;
    private String issueDate;

    public Press(String title, int issueNumber, String issueDate) {
        super(title);
        this.issueNumber = issueNumber;
        this.issueDate = issueDate;
    }

    public int getIssueNumber() {
        return issueNumber;
    }

    public String getIssueDate() {
        return issueDate;
    }
}
