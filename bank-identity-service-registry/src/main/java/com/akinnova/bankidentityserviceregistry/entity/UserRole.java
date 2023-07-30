package com.akinnova.bankidentityserviceregistry.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
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
    private Long id;
    private String role;
}
