package com.akinnova.banktransactionserviceregistry.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ReturnData {
    private String accountNumber;
    private String accountName;
    private BigDecimal accountBalance;
}
