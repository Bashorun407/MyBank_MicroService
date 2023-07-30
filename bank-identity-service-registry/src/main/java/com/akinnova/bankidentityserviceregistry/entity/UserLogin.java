package com.akinnova.bankidentityserviceregistry.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.Set;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "login_table",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "email")
        }
)
public class UserLogin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    @CreationTimestamp
    private LocalDateTime createdAt;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable( name = "user_roles",
            joinColumns = @JoinColumn(name = "user_mail", referencedColumnName = "email"),
            inverseJoinColumns = @JoinColumn(name = "user_role", referencedColumnName = "role")
    )
    private Set<UserRole> roles;
}
