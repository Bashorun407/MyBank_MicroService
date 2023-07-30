package com.akinnova.bankidentityserviceregistry.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
@Table (name = "user_role_table",
        uniqueConstraints = {
        @UniqueConstraint(columnNames = "role")
})
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String role;
}
