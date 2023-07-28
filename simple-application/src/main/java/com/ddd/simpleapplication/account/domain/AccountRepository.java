package com.ddd.simpleapplication.account.domain;

import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends Repository<Account, AccountId> {
    void save(Account account);
    Optional<Account> findById(AccountId id);
    void delete(Account account);
    List<Account> findAll();
}