package com.akinnova.bankidentityserviceregistry.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", unique = true)
    private Long id;
    private String firstName;
    private String lastName;
    private String otherName;
    private String gender;
    private String home_address;
    private String stateOfOrigin;
    private String accountNumber;
    private BigDecimal accountBalance;
    private String email;
    private String password;
    private String phoneNumber;
    private String alternativeNumber;
    private String status;
    private LocalDate dateOfBirth;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime modifiedAt;

}
