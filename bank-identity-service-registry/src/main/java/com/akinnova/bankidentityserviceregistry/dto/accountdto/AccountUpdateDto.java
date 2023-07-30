package com.akinnova.bankidentityserviceregistry.dto.accountdto;

import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class AccountUpdateDto {
    private String accountNumber;
    private BigDecimal amount;

    private String transactionType;
    private String modifiedBy;
    @UpdateTimestamp
    private LocalDateTime modifiedAt;
}
