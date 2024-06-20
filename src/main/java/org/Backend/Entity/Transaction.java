package org.Backend.Entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Transaction {
    private TransactionType type;
    private Long transactionNumber;
    private LocalDate date;
    private final Double amount;
    private Long accountID;
    private final List<Category> categories;
    private final String comment;

    public Transaction(TransactionType type, Double amount, Category category, String comment) {
        this.type = type;
        this.amount = amount;
        this.categories = new ArrayList<>();
        this.comment = comment;
    }

    public TransactionType getType() {
        return type;
    }

    public int getTransactionNumber() {
        return transactionNumber;
    }

    public LocalDate getDate() {
        return date;
    }

    public Double getAmount() {
        return amount;
    }

    public Long getAccountID() {
        return accountID;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public String getComment() {
        return comment;
    }

    public void setTransactionNumber(Long transactionNumber) {
        this.transactionNumber = transactionNumber;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setAccountID(Long accountID) {
        this.accountID = accountID;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "type=" + type +
                ", date=" + date +
                ", amount=" + amount +
                ", comment='" + comment + '\'' +
                '}';
    }
}
