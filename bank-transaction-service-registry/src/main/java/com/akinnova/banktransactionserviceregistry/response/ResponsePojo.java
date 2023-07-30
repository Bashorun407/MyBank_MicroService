package com.akinnova.banktransactionserviceregistry.response;

import lombok.Data;

@Data
public class ResponsePojo <T>{
    String status = "200";
    boolean success = true;
    String message;
    T data;
}
