package kz.donation.alerts.server.service;

import kz.donation.alerts.server.model.Account;

import java.util.List;

public interface IAccountService {
    Account addAccount(Account account);
    List<Account> getAllAccounts();
    Account getAccountById(Integer id);
    Account getAccountByUsername(String username);
    Account updateAccount(Account account);
    void deleteAccount(Account account);
    void deleteByAccountId(Integer id);
    Account changeCashAccount(Integer id, Double amount);
}
