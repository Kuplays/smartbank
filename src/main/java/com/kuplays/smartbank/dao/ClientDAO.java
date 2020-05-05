package com.kuplays.smartbank.dao;

import com.kuplays.smartbank.Client;
import org.springframework.stereotype.Component;

import java.util.List;

public interface ClientDAO {
    void insert(Client client);
    void update(Client client);
    void delete(long id);
    Client get(long id);
    List<Client> getAll();
}
