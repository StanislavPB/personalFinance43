package org.Backend.Repository;

import org.Backend.Entity.Category;
import org.Backend.Entity.Transaction;
import org.Backend.Entity.TransactionType;

import java.time.LocalDate;
import java.util.List;

public interface TransactionRepositoryInterface {

    void addTransaction(Transaction transaction);
    void deleteTransaction(Long TransactionNummer);
    Transaction findById(Long transactionNumber);
    List<Transaction> findByDate(LocalDate date);
    List<Transaction> findByType(TransactionType type);
    List<Transaction> findByCategory(Category category);
}
