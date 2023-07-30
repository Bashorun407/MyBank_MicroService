package com.akinnova.bankidentityserviceregistry.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "account_table",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "uniqueId")
        }
)
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String uniqueId;
    private String firstName;
    private String lastName;
    private String otherName;
    private String accountNumber;
    private String AccountType;
    private BigDecimal accountBalance;
    private String accountStatus;
    private String createdBy;
    @CreationTimestamp
    private LocalDateTime createdAt;
    private String modifiedBy;
    @UpdateTimestamp
    private LocalDateTime modifiedAt;
}
