package org.Backend.Entity;

import java.time.LocalDate;
import java.util.List;

public class Transaction {
    private TransactionType type;
    private Long transactionNumber;
    private LocalDate date;
    private Double amount;
    private Long accountID;
    private List<Category> categories;
    private String comment;

    public Transaction(TransactionType type, Double amount, List<Category> categories, String comment) {
        this.type = type;
        this.amount = amount;
        this.categories = categories;
        this.comment = comment;
    }

    public TransactionType getType() {
        return type;
    }

    public Long getTransactionNumber() {
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
