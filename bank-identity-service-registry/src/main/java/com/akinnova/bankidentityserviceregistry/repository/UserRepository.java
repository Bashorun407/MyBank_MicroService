package com.akinnova.bankidentityserviceregistry.repository;

import com.akinnova.bankidentityserviceregistry.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Boolean existsByAccountNumber(String accountNumber);
    Boolean existsByEmail(String email);
    Optional<User> findByAccountNumber(String accountNumber);
    Optional<User> findByEmail(String email);
}
