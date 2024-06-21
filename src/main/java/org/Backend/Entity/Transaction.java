package org.Backend.Entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Transaction {
    private TransactionType type;
    private Integer transactionNumber;
    private LocalDate date;
    private Double amount;
    private Integer accountID;
    private Category category;
    private String comment;

    public Transaction(TransactionType type, Double amount, Category category, String comment) {
        this.type = type;
        this.amount = amount;
        this.category = category;
        this.comment = comment;
    }

    public TransactionType getType() {
        return type;
    }

    public Integer getTransactionNumber() {
        return transactionNumber;
    }

    public LocalDate getDate() {
        return date;
    }

    public Double getAmount() {
        return amount;
    }

    public Integer getAccountID() {
        return accountID;
    }

    public Category getCategories() {
        return category;
    }

    public String getComment() {
        return comment;
    }

    public void setTransactionNumber(Integer transactionNumber) {
        this.transactionNumber = transactionNumber;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setAccountID(Integer accountID) {
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
