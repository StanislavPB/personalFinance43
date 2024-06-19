package org.Backend.DTO;

import org.Backend.Entity.Category;
import org.Backend.Entity.TransactionType;

import java.util.List;
public class CreateTransactionWithComment {
    private TransactionType type;
    private Integer fromAccountID;
    private Integer toAccountID;
    private Double amount;
    private Category category;
    private String comments;

    public CreateTransactionWithComment(TransactionType type, Integer fromAccountID, Integer toAccountID, Double amount, Category category, String comments) {
        this.type = type;
        this.fromAccountID = fromAccountID;
        this.toAccountID = toAccountID;
        this.amount = amount;
        this.category = category;
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "CreateTransactionWithComment{" +
                "type=" + type +
                ", fromAccountID=" + fromAccountID +
                ", toAccountID=" + toAccountID +
                ", amount=" + amount +
                ", category=" + category +
                ", comments='" + comments + '\'' +
                '}';
    }

    public TransactionType getType() {
        return type;
    }

    public Integer getFromAccountID() {
        return fromAccountID;
    }

    public Integer getToAccountID() {
        return toAccountID;
    }

    public Double getAmount() {
        return amount;
    }

    public Category getCategory() {
        return category;
    }

    public String getComments() {
        return comments;
    }
}




