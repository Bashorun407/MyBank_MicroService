package com.akinnova.bankidentityserviceregistry.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Set;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table (name = "user_table",
        uniqueConstraints = {
        @UniqueConstraint(columnNames = "uniqueId")
        }
)
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", unique = true)
    private Long id;
    private String firstName;
    private String lastName;
    private String otherName;
    private String gender;
    private String dateOfBirth;
    private String home_address;
    private String stateOfOrigin;
    private String uniqueId;
    private String phoneNumber;
    private String alternativeNumber;
    private String email;
    private String password;
    private String accountType;
    private String userStatus;
    private String createdBy;
    @CreationTimestamp
    private LocalDateTime createdAt;
    private String modifiedBy;
    @UpdateTimestamp
    private LocalDateTime modifiedAt;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable( name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "uniqueId"),
            inverseJoinColumns = @JoinColumn(name = "user_role", referencedColumnName = "role")
    )
    private Set<UserRole> roles;
}
