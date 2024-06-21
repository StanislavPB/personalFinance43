package org.Backend.Entity;

public class Account {
    private Integer accountId;
    private String accountName;
    private Double totalAmount;


    public Account(Integer accountId, String accountName, Double totalAmount) {
        this.accountId = accountId;
        this.accountName = accountName;
        this.totalAmount = totalAmount;

    }

    public Integer getAccountId() {
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

    public double changAmount(double amount){
        totalAmount = totalAmount + amount;
        return totalAmount;
    }

}
