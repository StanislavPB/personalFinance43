package org.Backend.Entity.DTO;


import org.Backend.Entity.Category;
import org.Backend.Entity.TransactionType;

import java.util.List;

public class SearchTransaction {
    private TransactionType type;
    private Double amount;
    private List<Category> categories;

    public SearchTransaction(TransactionType type, Double amount, List<Category> categories) {
        this.type = type;
        this.amount = amount;
        this.categories = categories;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "SearchTransaction{" +
                "type=" + type +
                ", amount=" + amount +
                ", categories=" + categories +
                '}';
    }
}

