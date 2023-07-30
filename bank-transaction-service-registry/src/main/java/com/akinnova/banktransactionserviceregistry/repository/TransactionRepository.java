package com.akinnova.banktransactionserviceregistry.repository;

import com.akinnova.banktransactionserviceregistry.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long>{

}
