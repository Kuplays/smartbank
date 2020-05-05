package com.kuplays.smartbank.dao;

import com.kuplays.smartbank.Transaction;

import java.sql.Date;
import java.util.List;

public interface TransactionDAO {
    void insert(Transaction transaction);
    void update(Transaction transaction);
    void delete(long id);
    Transaction get(long id);
    List<Transaction> getAll();
    List<Transaction> getAllById(String id);
    List<Transaction> getAllByDate(Date from, Date until);
    List<Transaction> getAllByClient(String id);
    List<Transaction> getAllByDateAndClient(Date from, Date until, String id);
}
