package org.Backend.Repository;

import org.Backend.Entity.Account;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AccountRepository implements AccountRepositoryInterface{

    private List<Account> accounts = new ArrayList<>();


    @Override
    public Account addNewAccount(Integer accountID, String accountName) {
        accounts.add(addNewAccount(accountID,accountName));
        return null;

    }

    @Override
    public void deleteAccount(Integer accountId) {
        Account account = accounts.get(accountId);
        if(account != null && account.getTotalAmount()>=0){
            accounts.remove(accountId);
        } else {
            System.out.println("Cannot delete account with negative balance");
        }

    }

    @Override
    public void transfer(Integer fromAccountID, Integer toAccountID, Double amount) {
        Account fromAccount = accounts.get(fromAccountID);
        Account toAccount = accounts.get(toAccountID);

        if(fromAccount != null && toAccount != null && fromAccount.getTotalAmount()>= amount){
            fromAccount.changAmount(-amount);
            toAccount.changAmount(amount);

        } else {
            System.out.println("Transfer not possible");

        }

}

    @Override
    public List<Account> findAll() {
        return new ArrayList<>(accounts);
    }

    @Override
    public Account findById(Integer accountId) {
        Optional<Account> account = accounts.stream()
                .filter(acc -> acc.getAccountId().equals(accountId))
                .findFirst();
        return account.orElse(null);

    }


}
