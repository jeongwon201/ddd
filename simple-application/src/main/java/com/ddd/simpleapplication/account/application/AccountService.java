package com.ddd.simpleapplication.account.application;

import com.ddd.simpleapplication.account.domain.Account;
import com.ddd.simpleapplication.account.domain.AccountId;
import com.ddd.simpleapplication.account.domain.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AccountService {

    private AccountRepository repository;
    private WelcomeMailSender welcomeMailSender;

    public AccountService(AccountRepository repository, WelcomeMailSender welcomeMailSender) {
        this.repository = repository;
        this.welcomeMailSender = welcomeMailSender;
    }

    public Account find(AccountId id) {
        Account account = repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("account not found."));

        return account;
    }

    public List<Account> findAll() {
        return repository.findAll();
    }

    public void add(AccountRequest request) {
        System.out.println(request.getId());
        System.out.println(request.getPassword());

        Account account = new Account(new AccountId(request.getId()), request.getPassword());

        System.out.println(account.getId());
        System.out.println(account.getId().getValue());
        System.out.println(account.getPassword());

        repository.save(account);
        welcomeMailSender.sendWelcomeMail(account.getId());
    }

    public void change(AccountRequest request) {
        Account account = repository.findById(new AccountId(request.getId()))
                .orElseThrow(() -> new NoSuchElementException("account not found."));

        account.changePassword(request.getPassword());
        repository.save(account);
    }

    public void delete(AccountId id) {
        Account account = repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("account not found."));

        repository.delete(account);
    }
}