package org.Backend.DTO;

public class AccountDTO {
    String accountName;
    Double totalAmount;

    public AccountDTO(String accountName, Double totalAmount) {
        this.accountName = accountName;
        this.totalAmount = totalAmount;
    }

    public String getAccountName() {
        return accountName;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    @Override
    public String toString() {
        return "AccountDTO{" +
                "accountName='" + accountName + '\'' +
                ", totalAmount=" + totalAmount +
                '}';
    }
}
