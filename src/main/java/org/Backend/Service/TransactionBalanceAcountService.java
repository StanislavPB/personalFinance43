package org.Backend.Service;

import org.Backend.DTO.ClientResponse;

import org.Backend.DTO.CreateTransactionWithComment;
import org.Backend.Entity.Account;
import org.Backend.Entity.Category;
import org.Backend.Entity.Transaction;
import org.Backend.Entity.TransactionType;
import org.Backend.Repository.AccountRepository;
import org.Backend.Repository.TransactionRepository;
import org.Backend.Repository.UserRepository;
import org.Backend.Service.Validation.Validation;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import static org.Backend.Entity.TransactionType.*;

public class TransactionBalanceAcountService {

    private  TransactionRepository transactionRepository;
    private  AccountRepository accountRepository;
    private UserRepository userRepository;
    private  Validation validation;

    public TransactionBalanceAcountService(TransactionRepository transactionRepository, AccountRepository accountRepository,UserRepository userRepository, Validation validation) {
        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
        this.userRepository = userRepository;
        this.validation = validation;
    }

    public TransactionBalanceAcountService() {
    }

    public ClientResponse<Transaction> add(CreateTransactionWithComment transactionRequest){
        validation.checkCreateTransaction(transactionRequest);
        Transaction transactionForAdd = new Transaction(transactionRequest.getType(),
                transactionRequest.getAmount(),transactionRequest.getCategory(),
                transactionRequest.getComments());
        transactionRepository.addTransaction(transactionForAdd);
        if( transactionForAdd.getTransactionNumber()>0){
            return new ClientResponse<>(200,transactionForAdd,"Транзакция прошла успешно");

        }else {
            return new ClientResponse<>(400,transactionForAdd,"Транзакция не прошла");

        }
    }
    public void updateAccountBalance(Transaction transaction) {
        Account account = accountRepository.findById(transaction.getAccountID());
        if (transaction.getType() == TransactionType.DEPOSIT) {
            account.changAmount(transaction.getAmount());
        } else if (transaction.getType() == TransactionType.WITHDRAWAL) {
            if (account.getTotalAmount() >= transaction.getAmount()) {
                account.changAmount(-transaction.getAmount());
            } else {
                System.out.println("Insufficient balance");
            }
        } else if (transaction.getType() == TransactionType.TRANSFER) {
            Account fromAccount = accountRepository.findById(transaction.getAccountID());
            Account toAccount = accountRepository.findById(transaction.getAccountID());
            if (fromAccount.getTotalAmount() >= transaction.getAmount()) {
                fromAccount.changAmount(-transaction.getAmount());
                toAccount.changAmount(transaction.getAmount());
            } else {
                System.out.println("Insufficient balance for transfer");
            }
        }
    }

    private void transferAccount(Integer fromAccountID, Integer toAccountID, Double amount) {
        accountRepository.transfer(fromAccountID,toAccountID,amount);

   }
    public Account findById(Integer accountId) {
        Account accountFoundet = null;
        if (accountId != null) {
            accountFoundet = accountRepository.findById(accountId);
        }
        return accountFoundet;
    }
//    public ClientResponse<List<Transaction>> getTransactionsByDate(LocalDate startDate, LocalDate endDate, Category category) {
//        List<Transaction> transactions = transactionRepository.findByDate()
//        return getTransactions(startDate, endDate, category).stream()
//                .filter(t -> t.getDate().isAfter(startDate) && t.getDate().isBefore(endDate))
//                .filter(t -> category == null || t.getCategories().equals(category))
//                .collect(Collectors.toList());
//    }
    public ClientResponse<List<Transaction>> findByDateRange(LocalDate startDate, LocalDate endDate) {
        List<Transaction> transactions = transactionRepository.findByDates(startDate, endDate);
        return new ClientResponse<>(200, transactions, "Список транзакций за указанный период");
    }
    public ClientResponse<List<Transaction>> findByDate(LocalDate date) {
        List<Transaction> transactions = transactionRepository.findByDate(date);
        return new ClientResponse<>(200, transactions, "Список транзакций за указанный период");
    }
}


