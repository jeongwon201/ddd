package com.ddd.account.application;

import com.ddd.account.domain.AccountId;

public interface WelcomeMailSender {
    void sendWelcomeMail(AccountId id);
}