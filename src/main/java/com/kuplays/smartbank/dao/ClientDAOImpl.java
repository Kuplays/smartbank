package com.kuplays.smartbank.dao;

import com.kuplays.smartbank.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ClientDAOImpl implements ClientDAO{
    @Autowired
    private JdbcTemplate jdbc;

    public ClientDAOImpl() {

    }

    @Override
    public void insert(Client client) {
        String statement = "INSERT INTO clients (age, name) VALUES(?, ?)";
        jdbc.update(statement, client.getAge(), client.getName());
    }

    @Override
    public void update(Client client) {
        String statement = "UPDATE clients SET age=?, name=? WHERE id=?)";
        jdbc.update(statement, client.getAge(), client.getName(), client.getId());
    }

    @Override
    public void delete(long id) {
        String statement = "DELETE FROM clients WHERE id=?";
        jdbc.update(statement, id);
    }

    @Override
    public Client get(long id) {
        String statement = "SELECT * FROM clients WHERE  id=" + id;
        return jdbc.queryForObject(statement, BeanPropertyRowMapper.newInstance(Client.class));
    }

    @Override
    public List<Client> getAll() {
        String sql = "SELECT * FROM clients";
        List<Client> allClients = jdbc.query(sql, new RowMapper<Client>() {

            @Override
            public Client mapRow(ResultSet rs, int rowNum) throws SQLException {
                Client client = new Client();
                client.setId(rs.getInt("id"));
                client.setAge(rs.getShort("age"));
                client.setName(rs.getString("name"));

                return client;
            }
        });

        return allClients;
    }
}
