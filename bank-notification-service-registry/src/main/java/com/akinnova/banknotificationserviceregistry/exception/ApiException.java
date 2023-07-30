package com.akinnova.banknotificationserviceregistry.exception;

public class ApiException extends RuntimeException{
    public ApiException(String message){
        super(message);
    }
}
