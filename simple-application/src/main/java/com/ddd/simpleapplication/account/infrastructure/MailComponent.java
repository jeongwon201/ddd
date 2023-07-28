package com.ddd.simpleapplication.account.infrastructure;

import com.ddd.simpleapplication.account.application.WelcomeMailSender;
import com.ddd.simpleapplication.account.domain.AccountId;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Component
public class MailComponent implements WelcomeMailSender {

    private JavaMailSender javaMailSender;

    public MailComponent(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public void sendWelcomeMail(AccountId id){
        try {
            MimeMessage message = createMail(id);
            javaMailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    private MimeMessage createMail(AccountId id) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();

        String msg = "Welcome to Domain Driven Design !";

        message.addRecipients(Message.RecipientType.TO, id.getValue());
        message.setFrom("naver email");
        message.setSubject("Welcome !");
        message.setText(msg, "utf-8", "html");
        return message;
    }
}