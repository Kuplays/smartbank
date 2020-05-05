package com.kuplays.smartbank.dao;

import com.kuplays.smartbank.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TransactionDAOImpl implements TransactionDAO {
    @Autowired
    private JdbcTemplate jdbc;

    public TransactionDAOImpl() {

    }

    @Override
    public void insert(Transaction transaction) {
        String statement = "INSERT INTO transactions (accountid, type, amount, clientid) VALUES(?, ?, ?, ?)";
        jdbc.update(statement, transaction.getAccountId(), transaction.getType(), transaction.getAmount(), transaction.getClientId());
    }

    @Override
    public void update(Transaction transaction) {
        String statement = "UPDATE transactions SET accountid=?, type=?, amount=? WHERE id=?";
        jdbc.update(statement, transaction.getAccountId(), transaction.getType(), transaction.getAmount(), transaction.getId());
    }

    @Override
    public void delete(long id) {
        String statement = "DELETE FROM transaction WHERE id=?";
        jdbc.update(statement, id);
    }

    @Override
    public Transaction get(long id) {
        String statement = "SELECT * FROM transactions WHERE  id=" + id;
        return jdbc.queryForObject(statement, BeanPropertyRowMapper.newInstance(Transaction.class));
    }

    @Override
    public List<Transaction> getAll() {
        String sql = "SELECT * FROM transactions ORDER BY id DESC";
        List<Transaction> allTransactions = jdbc.query(sql, new RowMapper<Transaction>() {

            @Override
            public Transaction mapRow(ResultSet rs, int rowNum) throws SQLException {
                Transaction transaction = new Transaction();
                transaction.setId(rs.getInt("id"));
                transaction.setAccountId(rs.getInt("accountid"));
                transaction.setType(rs.getString("type"));
                transaction.setDate(rs.getDate("tdate"));
                transaction.setAmount(rs.getDouble("amount"));
                transaction.setClientId(rs.getInt("clientid"));

                return transaction;
            }
        });

        return allTransactions;
    }

    @Override
    public List<Transaction> getAllById(String id) {
        String sql = "SELECT * FROM transactions WHERE clientid=" + id + " ORDER BY id DESC";
        List<Transaction> allTransactions = jdbc.query(sql, new RowMapper<Transaction>() {

            @Override
            public Transaction mapRow(ResultSet rs, int rowNum) throws SQLException {
                Transaction transaction = new Transaction();
                transaction.setId(rs.getInt("id"));
                transaction.setAccountId(rs.getInt("accountid"));
                transaction.setType(rs.getString("type"));
                transaction.setDate(rs.getDate("tdate"));
                transaction.setAmount(rs.getDouble("amount"));
                transaction.setClientId(rs.getInt("clientid"));

                return transaction;
            }
        });

        return allTransactions;
    }

    @Override
    public List<Transaction> getAllByDate(Date from, Date until) {
        String sql = "SELECT * FROM transactions WHERE tdate BETWEEN '" + from + "' AND '" + until.toLocalDate() + "' ORDER BY id DESC";
        List<Transaction> allTransactions = jdbc.query(sql, new RowMapper<Transaction>() {

            @Override
            public Transaction mapRow(ResultSet rs, int rowNum) throws SQLException {
                Transaction transaction = new Transaction();
                transaction.setId(rs.getInt("id"));
                transaction.setAccountId(rs.getInt("accountid"));
                transaction.setType(rs.getString("type"));
                transaction.setDate(rs.getDate("tdate"));
                transaction.setAmount(rs.getDouble("amount"));
                transaction.setClientId(rs.getInt("clientid"));

                return transaction;
            }
        });

        return allTransactions;
    }

    @Override
    public List<Transaction> getAllByClient(String id) {
        String sql = "SELECT * FROM transactions WHERE clientid=" + id + " ORDER BY id DESC";
        List<Transaction> allTransactions = jdbc.query(sql, new RowMapper<Transaction>() {

            @Override
            public Transaction mapRow(ResultSet rs, int rowNum) throws SQLException {
                Transaction transaction = new Transaction();
                transaction.setId(rs.getInt("id"));
                transaction.setAccountId(rs.getInt("accountid"));
                transaction.setType(rs.getString("type"));
                transaction.setDate(rs.getDate("tdate"));
                transaction.setAmount(rs.getDouble("amount"));
                transaction.setClientId(rs.getInt("clientid"));

                return transaction;
            }
        });

        return allTransactions;
    }

    @Override
    public List<Transaction> getAllByDateAndClient(Date from, Date until, String id) {
        String sql = "SELECT * FROM transactions WHERE tdate BETWEEN '" + from + "' AND '" + until.toLocalDate() + "' AND clientid=" + id + " ORDER BY id DESC";
        List<Transaction> allTransactions = jdbc.query(sql, new RowMapper<Transaction>() {

            @Override
            public Transaction mapRow(ResultSet rs, int rowNum) throws SQLException {
                Transaction transaction = new Transaction();
                transaction.setId(rs.getInt("id"));
                transaction.setAccountId(rs.getInt("accountid"));
                transaction.setType(rs.getString("type"));
                transaction.setDate(rs.getDate("tdate"));
                transaction.setAmount(rs.getDouble("amount"));
                transaction.setClientId(rs.getInt("clientid"));

                return transaction;
            }
        });

        return allTransactions;
    }
}
