package com.akinnova.bankidentityserviceregistry.service.accountservice;

import com.akinnova.bankidentityserviceregistry.entity.Account;
import com.akinnova.bankidentityserviceregistry.exception.ApiException;
import com.akinnova.bankidentityserviceregistry.repository.AccountRepository;
import com.akinnova.bankidentityserviceregistry.response.ResponseUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService implements IAccountService{
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public ResponseEntity<?> accountDetails(String accountNumber) {

        // TODO: 7/29/2023 There should be a means to validate the user asking for account details
        Optional<Account> accountOptional = accountRepository.findByAccount(accountNumber);
        accountOptional.orElseThrow(()-> new ApiException(String.format("Account with account-number: %s does not exist",
                accountNumber)));

        Account account = accountOptional.get();

        if(account.getAccountStatus().equals(ResponseUtils.NON_ACTIVE))
            return new ResponseEntity<>("Account has been deactivated. Contact customer care.", HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(account, HttpStatus.FOUND);
    }
}
