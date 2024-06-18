package org.Backend.DTO;

import org.Backend.Entity.Category;
import org.Backend.Entity.TransactionType;

import java.util.List;

public class CreateTransaction { public class CreateTransactionWithComment {
    private TransactionType type;
    private Double amount;
    private List<Category> category;
    private String comment;

    public CreateTransactionWithComment(TransactionType type, Double amount, List<Category> category, String comment) {
        this.type = type;
        this.amount = amount;
        this.category = category;
        this.comment = comment;

    }

    public TransactionType getType() {
        return type;
    }

    public Double getAmount() {
        return amount;
    }

    public List<Category> getCategory() {
        return category;
    }

    public String getComment() {
        return comment;
    }

    @Override
    public String toString() {
        return "CreateTransactionWithComment{" +
                "type=" + type +
                ", amount=" + amount +
                ", category=" + category +
                ", comment='" + comment + '\'' +
                '}';
    }

}
}



