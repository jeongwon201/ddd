package com.ddd.simpleapplication.account.application;


import com.ddd.simpleapplication.account.domain.AccountId;

public interface WelcomeMailSender {
    void sendWelcomeMail(AccountId id);
}