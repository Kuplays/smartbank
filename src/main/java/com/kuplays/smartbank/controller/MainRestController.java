package com.kuplays.smartbank.controller;

import com.kuplays.smartbank.Account;
import com.kuplays.smartbank.Client;
import com.kuplays.smartbank.Transaction;
import com.kuplays.smartbank.dao.AccountDAO;
import com.kuplays.smartbank.dao.ClientDAO;
import com.kuplays.smartbank.dao.TransactionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MainRestController {
    @Autowired
    private ClientDAO clientDAO;
    @Autowired
    private AccountDAO accountDAO;
    @Autowired
    private TransactionDAO transactionDAO;

    public MainRestController() {

    }

    @GetMapping("/all")
    public List<Client> getClients() {
        return (List<Client>)clientDAO.getAll();
    }

    @GetMapping("/all/{id}")
    public Client getClientById(@PathVariable long id) {
        return clientDAO.get(id);
    }

    @PostMapping("/all")
    public void addClient(@RequestBody Client client) {
        clientDAO.insert(client);
    }

    @GetMapping("/clientaccounts")
    public List<Account> getAccounts() {
        return (List<Account>)accountDAO.getAll();
    }

    @GetMapping("/clientaccounts/{id}")
    public List<Account> getAccountsById(@PathVariable String id) {return (List<Account>)accountDAO.getAllById(id);}

    @PostMapping("/clientaccounts")
    public void addAccount(@RequestBody Account account) {
        accountDAO.insert(account);
    }

    @PostMapping("/transactions")
    public void addTransaction(@RequestBody Transaction transaction) {
        if (transaction.getAccountId() == transaction.getRecepientId()) {
            if (transaction.getType().compareTo("OUTCOME") == 0) {
                Account temp = accountDAO.get(transaction.getRecepientId());
                if (temp.getBalance() >= transaction.getAmount()) {
                    temp.setBalance(temp.getBalance() - transaction.getAmount());
                    accountDAO.update(temp);
                } else return;
            } else if (transaction.getType().compareTo("INCOME") == 0){
                Account temp = accountDAO.get(transaction.getRecepientId());
                temp.setBalance(temp.getBalance() + transaction.getAmount());
                accountDAO.update(temp);
            } else return;
        } else {
            if (transaction.getType().compareTo("TRANSFER") == 0) {
                Account sender = accountDAO.get(transaction.getAccountId());
                Account recepient = accountDAO.get(transaction.getRecepientId());
                if (sender.getBalance() >= transaction.getAmount()) {
                    sender.setBalance(sender.getBalance() - transaction.getAmount());
                    recepient.setBalance(recepient.getBalance() + transaction.getAmount());
                    accountDAO.update(sender);
                    accountDAO.update(recepient);
                } else return;
            }
        }
        transactionDAO.insert(transaction);
    }

    @GetMapping("/transactions/{id}")
    public List<Transaction> getTransactionsById(@PathVariable String id) {return (List<Transaction>)transactionDAO.getAllById(id);}

    @GetMapping("/transactions")
    public List<Transaction> getTransactionsByDates(@RequestParam Map<String, String> customQuery) {
        if (customQuery.containsKey("from")
                && customQuery.containsKey("until") && !customQuery.containsKey("clientid")) {
            Date from = Date.valueOf(customQuery.get("from"));
            Date until = Date.valueOf(customQuery.get("until"));
            return (List<Transaction>)transactionDAO.getAllByDate(from, until);
        } else if (customQuery.containsKey("clientid")
                && (!customQuery.containsKey("from") || !customQuery.containsKey("until"))) {
            String id = customQuery.get("clientid");
            return (List<Transaction>)transactionDAO.getAllByClient(id);
        } else if (customQuery.containsKey("from")
                && customQuery.containsKey("until") && customQuery.containsKey("clientid")) {
            Date from = Date.valueOf(customQuery.get("from"));
            Date until = Date.valueOf(customQuery.get("until"));
            String id = customQuery.get("clientid");
            return (List<Transaction>)transactionDAO.getAllByDateAndClient(from, until, id);
        } else {
            return (List<Transaction>)transactionDAO.getAll();
        }
    }
}
