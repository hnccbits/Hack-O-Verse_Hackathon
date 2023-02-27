package com.example.safecampus;

public class MessageModel {
    private String userEmail;
    private  String userMessage;
    private  String date_Time;

    public MessageModel() {
    }

    public MessageModel(String userEmail, String userMessage, String date_Time) {
        this.userEmail=userEmail;
        this.userMessage=userMessage;
        this.date_Time=date_Time;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserMessage() {
        return userMessage;
    }

    public void setUserMessage(String userMessage) {
        this.userMessage = userMessage;
    }

    public String getDate_Time() {
        return date_Time;
    }

    public void setDate_Time(String date_Time) {
        this.date_Time = date_Time;
    }
}