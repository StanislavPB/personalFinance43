package org.Backend.Repository;

import org.Backend.DTO.CreateTransactionWithComment;
import org.Backend.Entity.Account;
import org.Backend.Entity.Category;
import org.Backend.Entity.Transaction;
import org.Backend.Entity.TransactionType;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TransactionRepository implements TransactionRepositoryInterface {

    private List<Transaction> transactions = new ArrayList<>();
    private Integer counter = 0;


    @Override
    public void addTransaction(Transaction transaction) {
        LocalDate today = LocalDate.now();
        transaction.setTransactionNumber(++counter);
        transaction.setDate(today);
        transactions.add(transaction.getTransactionNumber(),transaction);
        counter ++;
    }

    @Override
    public void deleteTransaction(Integer transactionNumber) {
        transactions.remove(transactions.get(transactionNumber));
    }

    @Override
    public Transaction findById(Integer transactionNumber) {
        return transactions.get(transactionNumber);
    }

    @Override
    public List<Transaction> findByDate(LocalDate date) {
        return transactions.stream()
                .filter(transaction -> transaction.getDate().equals(date))
                .collect(Collectors.toList());
    }
    public List<Transaction> findByDates(LocalDate startDate,LocalDate endDate) {
        return transactions.stream()
                .filter(transaction -> !transaction.getDate().isBefore(startDate)  && !transaction.getDate().isAfter(endDate))
                .collect(Collectors.toList());
    }

    @Override
    public List<Transaction> findByType(TransactionType type) {
        return transactions.stream()
                .filter(transaction -> transaction.getType().equals(type))
                .collect(Collectors.toList());
    }

    @Override
    public List<Transaction> findByCategory(Category category) {
        return transactions.stream()
                .filter(transaction -> transaction.getCategories().equals(category))
                .collect(Collectors.toList());
    }
}
