package com.akinnova.banktransactionserviceregistry.service;

import com.akinnova.banktransactionserviceregistry.dto.ReturnData;
import com.akinnova.banktransactionserviceregistry.dto.TransactionDto;
import com.akinnova.banktransactionserviceregistry.dto.TransactionRequest;
import com.akinnova.banktransactionserviceregistry.dto.TransferRequest;
import com.akinnova.banktransactionserviceregistry.entity.Transaction;
import com.akinnova.banktransactionserviceregistry.repository.TransactionRepository;
import com.akinnova.banktransactionserviceregistry.response.ResponsePojo;
import org.springframework.stereotype.Service;

@Service
public class TransactionService implements ITransactionService {
    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public ResponsePojo<ReturnData> creditAccount(TransactionRequest transactionRequest) {
        return null;
    }

    @Override
    public ResponsePojo<ReturnData> debitAccount(TransactionRequest transactionRequest) {
        return null;
    }

    @Override
    public ResponsePojo<ReturnData> transferAmount(TransferRequest transferRequest) {
        return null;
    }

    @Override
    public void saveTransaction(TransactionDto transactionDto) {
        {
            Transaction transaction = Transaction.builder()
                    .transactionType(transactionDto.getTransactionType())
                    .accountNumber(transactionDto.getAccountNumber())
                    .amount(transactionDto.getAmount())
                    .build();

            transactionRepository.save(transaction);
        }
    }
}
