package com.kuplays.smartbank.dao;

import com.kuplays.smartbank.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO {
    @Autowired
    private JdbcTemplate jdbc;

    public AccountDAOImpl() {

    }

    @Override
    public void insert(Account account) {
        String statement = "INSERT INTO accounts (clientid, balance) VALUES(?, ?)";
        jdbc.update(statement, account.getClientId(), account.getBalance());
    }

    @Override
    public void update(Account account) {
        String statement = "UPDATE accounts SET clientid=?, balance=? WHERE id=?";
        jdbc.update(statement, account.getClientId(), account.getBalance(), account.getId());
    }

    @Override
    public void delete(long id) {
        String statement = "DELETE FROM accounts WHERE id=?";
        jdbc.update(statement, id);
    }

    @Override
    public Account get(long id) {
        String statement = "SELECT * FROM accounts WHERE  id=" + id;
        return jdbc.queryForObject(statement, BeanPropertyRowMapper.newInstance(Account.class));
    }

    @Override
    public List<Account> getAll() {
        String sql = "SELECT * FROM accounts";
        List<Account> allAccounts = jdbc.query(sql, new RowMapper<Account>() {

            @Override
            public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
                Account account = new Account();
                account.setId(rs.getInt("id"));
                account.setClientId(rs.getInt("clientid"));
                account.setBalance(rs.getDouble("balance"));

                return account;
            }
        });

        return allAccounts;
    }

    @Override
    public List<Account> getAllById(String id) {
        String sql = "SELECT * FROM accounts WHERE clientid=" + id;
        List<Account> allAccounts = jdbc.query(sql, new RowMapper<Account>() {

            @Override
            public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
                Account account = new Account();
                account.setId(rs.getInt("id"));
                account.setClientId(rs.getInt("clientid"));
                account.setBalance(rs.getDouble("balance"));

                return account;
            }
        });

        return allAccounts;
    }
}
