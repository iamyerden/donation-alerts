package kz.donation.alerts.server.service.impl;

import kz.donation.alerts.server.model.Account;
import kz.donation.alerts.server.repository.AccountRepository;
import kz.donation.alerts.server.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService implements IAccountService {

    @Autowired
    AccountRepository accountRepository;

    @Override
    public Account addAccount(Account account) {
        if(account.getCash() == null)
            account.setCash(0.0);
        return this.accountRepository.save(account);
    }

    @Override
    public List<Account> getAllAccounts() {
        return this.accountRepository.findAll();
    }

    @Override
    public Account getAccountById(Integer id) {
        return this.accountRepository.getById(id);
    }

    @Override
    public Account getAccountByUsername(String username) {
        return this.accountRepository.getByUsername(username);
    }

    @Override
    public Account updateAccount(Account account) {
        return this.accountRepository.save(account);
    }

    @Override
    public void deleteAccount(Account account) {
        this.accountRepository.delete(account);
    }

    @Override
    public void deleteByAccountId(Integer id) {
        this.accountRepository.deleteById(id);
    }

    @Override
    public Account changeCashAccount(Integer id, Double amount) {
        Account account = this.accountRepository.getById(id);
        account.setCash(account.getCash() + amount);
        return account;
    }
}
