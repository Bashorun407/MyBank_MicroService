package com.akinnova.banktransactionserviceregistry.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TransferRequest {
    private String senderAccountNumber;
    private String destinationAccountNumber;
    private BigDecimal amount;
}
