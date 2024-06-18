package org.Backend.Repository;

import org.Backend.Entity.Account;

import java.util.List;

interface AccountRepositoryInterface {

    Account addNewAccount(Integer accountID, String accountName);
    void deleteAccount(Integer accountId);
    void transfer(Integer fromAccountID, Integer toAccountID, Double amount);
    List<Account> findAll();
    Account findById(Integer accountId);



}
