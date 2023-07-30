package com.akinnova.banktransactionserviceregistry.service;

import com.akinnova.banktransactionserviceregistry.dto.ReturnData;
import com.akinnova.banktransactionserviceregistry.dto.TransactionDto;
import com.akinnova.banktransactionserviceregistry.dto.TransactionRequest;
import com.akinnova.banktransactionserviceregistry.dto.TransferRequest;
import com.akinnova.banktransactionserviceregistry.response.ResponsePojo;

public interface ITransactionService {
    ResponsePojo<ReturnData> creditAccount(TransactionRequest transactionRequest);
    ResponsePojo<ReturnData> debitAccount(TransactionRequest transactionRequest);
    ResponsePojo<ReturnData> transferAmount(TransferRequest transferRequest);
    void saveTransaction(TransactionDto transactionDto);
}
