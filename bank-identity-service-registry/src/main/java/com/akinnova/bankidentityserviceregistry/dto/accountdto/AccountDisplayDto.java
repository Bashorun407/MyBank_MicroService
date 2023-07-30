package com.akinnova.bankidentityserviceregistry.dto.accountdto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class AccountDisplayDto {
    private String firstName;
    private String lastName;
    private String accountNumber;
    private BigDecimal accountBalance;

}
