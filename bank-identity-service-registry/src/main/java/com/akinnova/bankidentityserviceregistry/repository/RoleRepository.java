package com.akinnova.bankidentityserviceregistry.repository;

import com.akinnova.bankidentityserviceregistry.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<UserRole, Long> {
}
