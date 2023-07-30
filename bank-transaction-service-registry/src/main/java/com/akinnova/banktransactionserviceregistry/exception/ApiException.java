package com.akinnova.banktransactionserviceregistry.exception;

import org.springframework.data.jpa.repository.JpaRepository;

public class ApiException extends RuntimeException {
    public ApiException(String message){
        super(message);
    }
}
