package com.library.models;

public class Journal extends Press{
    private String mainTopic;

    public Journal(String title, int issueNumber, String issueDate, String mainTopic) {
        super(title, issueNumber, issueDate);
        this.mainTopic = mainTopic;
    }

    public String getMainTopic() {
        return mainTopic;
    }

    @Override
    public String toString() {
        return structureInfo("ЖУРНАЛ",
                "Номер випуску: " + getIssueNumber()+
                        "\nЧисло випуску: " + getIssueDate() +
                        "\nГоловна тема: " + mainTopic);
    }

}
