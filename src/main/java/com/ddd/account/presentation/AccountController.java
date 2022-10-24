package com.ddd.account.presentation;

import com.ddd.account.application.AccountRequest;
import com.ddd.account.application.AccountService;
import com.ddd.account.domain.Account;
import com.ddd.account.domain.AccountId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {
    private AccountService service;

    public AccountController(AccountService service) {
        this.service = service;
    }

    @PostMapping("/account")
    public ResponseEntity register(@RequestBody AccountRequest request) {
        service.add(request);
       return ResponseEntity.ok("Check the email of the account you signed up for");
    }

    @GetMapping("/account/{id}")
    public ResponseEntity find(@PathVariable("id") String id) {
        Account account = service.find(new AccountId(id));
        return ResponseEntity.ok(account);
    }

    @PutMapping("/account/{id}")
    public ResponseEntity change(@PathVariable("id") String id, @RequestBody AccountRequest request) {
        request.setId(id);
        service.change(request);
        return ResponseEntity.ok("Your password has been changed.");
    }

    @DeleteMapping("/account/{id}")
    public ResponseEntity delete(@PathVariable("id") String id) {
        service.delete(new AccountId(id));
        return ResponseEntity.ok("Your account has been deleted.");
    }

    @GetMapping("/accounts")
    public ResponseEntity findAll() {
        return ResponseEntity.ok(service.findAll());
    }
}
