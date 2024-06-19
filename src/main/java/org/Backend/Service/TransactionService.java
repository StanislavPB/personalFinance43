package org.Backend.Service;

import org.Backend.DTO.ClientResponse;

import org.Backend.DTO.CreateTransactionWithComment;
import org.Backend.Entity.Transaction;
import org.Backend.Repository.TransactionRepository;
import org.Backend.Service.Validation.Validation;

public class TransactionService {

    private final TransactionRepository transactionRepository;

    private final Validation validation;

    public TransactionService(TransactionRepository transactionRepository, Validation validation) {
        this.transactionRepository = transactionRepository;
        this.validation = validation;
    }
    public ClientResponse<Transaction> add(CreateTransactionWithComment transactionRequest){
        validation.checkCreateTransaction(transactionRequest);
        Transaction transactionForAdd = new Transaction(transactionRequest.getType(),transactionRequest.getAmount(),transactionRequest.getCategory(),transactionRequest.getComment());
        transactionRepository.addTransaction(transactionForAdd);

        if( transactionForAdd.getTransactionNumber()>0){
            return new ClientResponse<>(200,transactionForAdd,"Транзакция прошла успешно");

        }else {
            return new ClientResponse<>(400,transactionForAdd,"Транзакция не прошла");

        }
    }

}
