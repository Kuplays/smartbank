package com.kuplays.smartbank;

import java.sql.Date;

public class Transaction {
    private long id;
    private long accountId;
    private String type;
    private Date date;
    private double amount;
    private long clientId;
    private long recepientId;

    public Transaction() {}
    public Transaction(long id, long accountId, String type, String date, double amount, long clientId, long recepientId) {
        this.id = id;
        this.accountId = accountId;
        this.type = type;
        this.date = Date.valueOf(date);
        this.amount = amount;
        this.clientId = clientId;
        this.recepientId = recepientId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    public long getRecepientId() {
        return recepientId;
    }

    public void setRecepientId(long recepientId) {
        this.recepientId = recepientId;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", accountId=" + accountId +
                ", type='" + type + '\'' +
                ", date=" + date +
                ", amount=" + amount +
                ", clientId=" + clientId +
                ", recepientId=" + recepientId +
                '}';
    }
}
