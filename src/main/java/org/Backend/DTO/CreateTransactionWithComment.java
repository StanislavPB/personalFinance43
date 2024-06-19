package org.Backend.DTO;

import org.Backend.Entity.Category;
import org.Backend.Entity.TransactionType;

import java.util.List;
public class CreateTransactionWithComment {
    private TransactionType type;
    private Double amount;
    private Category category;
    private String comments;

    public CreateTransactionWithComment(TransactionType type, Double amount, Category category, String comment) {
        this.type = type;
        this.amount = amount;
        this.category = category;
        this.comments = comment;

    }

    public TransactionType getType() {
        return type;
    }

    public Double getAmount() {
        return amount;
    }

    public Category getCategory() {
        return category;
    }

    public String getComment() {
        return comments;
    }

    @Override
    public String toString() {
        return "CreateTransactionWithComment{" +
                "type=" + type +
                ", amount=" + amount +
                ", category=" + category +
                ", comment='" + comments + '\'' +
                '}';
    }

}




