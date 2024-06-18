package org.Backend.Repository;

import org.Backend.Entity.Account;
import org.Backend.Entity.Category;
import org.Backend.Entity.Transaction;
import org.Backend.Entity.TransactionType;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TransactionRepository implements TransactionRepositoryInterface {

    private Map<Long, Transaction> transactions = new HashMap<>();



    @Override
    public void addTransaction(Transaction transaction) {
        transactions.put(transaction.getTransactionNumber(),transaction);

    }

    @Override
    public void deleteTransaction(Long transactionNumber) {
        transactions.remove(transactionNumber);

    }

    @Override
    public Transaction findById(Long transactionNumber) {
        return transactions.get(transactionNumber);
    }

    @Override
    public List<Transaction> findByDate(LocalDate date) {
        return transactions.values().stream()
                .filter(transaction -> transaction.getDate().equals(date))
                .collect(Collectors.toList());
    }

    @Override
    public List<Transaction> findByType(TransactionType type) {
        return transactions.values().stream()
                .filter(transaction -> transaction.getType().equals(type))
                .collect(Collectors.toList());
    }

    @Override
    public List<Transaction> findByCategory(Category category) {
        return transactions.values().stream()
                .filter(transaction -> transaction.getCategories().equals(category))
                .collect(Collectors.toList());
    }
}
