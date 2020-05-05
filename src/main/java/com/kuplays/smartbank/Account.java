package com.kuplays.smartbank;

public class Account {
    private long id;
    private long clientId;
    private double balance;

    public Account() {}
    public Account(long id, long clientId, double balance) {
        this.id = id;
        this.clientId = clientId;
        this.balance = balance;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", clientId=" + clientId +
                ", balance=" + balance +
                '}';
    }
}
