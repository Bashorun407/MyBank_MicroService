package com.akinnova.bankidentityserviceregistry.controller;

import com.akinnova.bankidentityserviceregistry.service.accountservice.AccountService;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/account/auth")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @GetMapping("/detail/{accountNumber}")
    public ResponseEntity<?> accountDetails(@PathVariable String accountNumber) {
        return accountService.accountDetails(accountNumber);
    }
}
