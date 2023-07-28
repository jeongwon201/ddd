package com.ddd.simpleapplication.account.domain;

import javax.persistence.*;

@Entity
@Table(name = "account")
@Access(AccessType.FIELD)
public class Account {

    @EmbeddedId
    private AccountId id;

    private String password;

    protected Account() {}

    public Account(AccountId id, String password) {
        this.id = id;
        this.password = password;
    }

    private void setId(AccountId id) {
        if(id == null) throw new NullPointerException("id cannot be null.");
        if(id.equals("")) throw new IllegalArgumentException("id cannot be blank.");
        this.id = id;
    }

    public void changePassword(String password) {
        this.password = password;
    }

    public AccountId getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }
}