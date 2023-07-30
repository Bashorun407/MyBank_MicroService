package com.akinnova.bankidentityserviceregistry.service.accountservice;


import org.springframework.http.ResponseEntity;

public interface IAccountService {
    ResponseEntity<?> accountDetails(String accountNumber);
}
