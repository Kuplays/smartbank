package com.kuplays.smartbank.dao;

import com.kuplays.smartbank.Account;

import java.util.List;

public interface AccountDAO {
    void insert(Account account);
    void update(Account account);
    void delete(long id);
    Account get(long id);
    List<Account> getAll();
    List<Account> getAllById(String id);
}
