package com.akinnova.banktransactionserviceregistry.dto;

import lombok.Builder;
import lombok.Data;
import java.math.BigDecimal;
@Data
@Builder
public class TransactionDto {
    private String transactionType;
    private String accountNumber;
    private BigDecimal amount;
}
