package com.playground.practice.egen;

import java.sql.Timestamp;

public class Order {
    int id;
    double amount;
    Timestamp date;
    String emailId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public Order(int id, double amount, Timestamp date, String emailId) {
        this.id = id;
        this.amount = amount;
        this.date = date;
        this.emailId = emailId;
    }
}
