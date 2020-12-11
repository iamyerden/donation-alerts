package kz.donation.alerts.server.controller;

import kz.donation.alerts.server.model.Account;
import kz.donation.alerts.server.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping()
public class AccountController {

    @Autowired
    IAccountService accountService;

    @RequestMapping(value = "/public/account/all/iterable", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public List<Account> getAllIterable() {
        return accountService.getAllAccounts();
    }

    @RequestMapping(value = "/public/account/search", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public List<Account> search(@RequestParam String username) {
        return accountService.search(username);
    }

    @RequestMapping(value = "/public/account/read/{id}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public Account get(@PathVariable("id") Integer id) {
        return accountService.getAccountById(id);
    }

    @RequestMapping(value = "/public/account/read", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public Account get(@RequestParam String username) {
        return accountService.getAccountByUsername(username);
    }

    @RequestMapping(value = "/public/account/create", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public Account create(@RequestBody Account account) {
        return accountService.addAccount(account);
    }

    @RequestMapping(value = "/public/account/update", method = RequestMethod.PUT, produces = "application/json;charset=UTF-8")
    public Account update(@RequestBody Account account) {
        return accountService.updateAccount(account);
    }

    @RequestMapping(value = "/public/account/delete/{id}", method = RequestMethod.DELETE, produces = "application/json;charset=UTF-8")
    public void deleteById(@PathVariable("id") Integer id) {
        accountService.deleteByAccountId(id);
    }
}
