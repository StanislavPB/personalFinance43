package org.Backend.Entity;

public class Account {
    private Long accountId;
    private String accountName;
    private Double totalAmount;

    public Account(Long accountId, String accountName, Double totalAmount) {
        this.accountId = accountId;
        this.accountName = accountName;
        this.totalAmount = totalAmount;
    }

    public Long getAccountId() {
        return accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", accountName='" + accountName + '\'' +
                ", totalAmount=" + totalAmount +
                '}';
    }
}
