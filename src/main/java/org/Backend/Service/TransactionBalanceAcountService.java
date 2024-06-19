package org.Backend.Service;

import org.Backend.DTO.ClientResponse;

import org.Backend.DTO.CreateTransactionWithComment;
import org.Backend.Entity.Account;
import org.Backend.Entity.Transaction;
import org.Backend.Repository.AccountRepository;
import org.Backend.Repository.TransactionRepository;
import org.Backend.Service.Validation.Validation;

import static org.Backend.Entity.TransactionType.*;

public class TransactionBalanceAcountService {

    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;
    private final Validation validation;

    public TransactionBalanceAcountService(TransactionRepository transactionRepository, AccountRepository accountRepository, Validation validation) {
        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
        this.validation = validation;
    }

    public ClientResponse<Transaction> add(CreateTransactionWithComment transactionRequest){
        validation.checkCreateTransaction(transactionRequest);
        Transaction transactionForAdd = new Transaction(transactionRequest.getType(),transactionRequest.getAmount(),transactionRequest.getCategory(),transactionRequest.getComments());
        transactionRepository.addTransaction(transactionForAdd);



        if( transactionForAdd.getTransactionNumber()>0){
            return new ClientResponse<>(200,transactionForAdd,"Транзакция прошла успешно");

        }else {
            return new ClientResponse<>(400,transactionForAdd,"Транзакция не прошла");

        }
    }
private Double updateAcount (Integer acountId,Transaction transaction) {
    Account account = accountRepository.findById(acountId);
    Double amount = account.getTotalAmount();
    if (transaction.getType() == DEPOSIT) {
        Double acountBalance = amount + transaction.getAmount();
        amount = acountBalance;
    }

    if (transaction.getType() == WITHDRAWAL) {
        if (amount >= transaction.getAmount()) {

            Double acountBalance = amount - transaction.getAmount();
            amount = acountBalance;
        }else {
            System.out.println("Не достаточно средств на счету");
        }
    }

    return amount;
    }
    private void transferAccount(Integer fromAccountID, Integer toAccountID, Double amount) {
       accountRepository.transfer();
    }
}


