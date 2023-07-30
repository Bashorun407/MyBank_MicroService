package com.akinnova.bankidentityserviceregistry.repository;

import com.akinnova.bankidentityserviceregistry.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Boolean existsByEmail(String email);
    Optional<UserEntity> findByUniqueId(String id);
    Optional<UserEntity> findByEmail(String email);
}
