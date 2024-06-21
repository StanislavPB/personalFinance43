package org.Backend.Service;

import org.Backend.Entity.Account;
import org.Backend.Entity.User;
import org.Backend.Repository.AccountRepository;
import org.Backend.Repository.TransactionRepository;
import org.Backend.Repository.UserRepository;
import org.Backend.Service.Validation.Validation;
import org.FrontEnd.UserMenu2;


public class Demo {
    public static void main(String[] args) {

        AccountRepository accountRepository = new AccountRepository();
        TransactionRepository transactionRepository = new TransactionRepository();
        Validation validation = new Validation();
        UserRepository userRepository = new UserRepository();
        TransactionBalanceAcountService service = new TransactionBalanceAcountService(transactionRepository, accountRepository, userRepository, validation);
        UserMenu2 userMenu2 = new UserMenu2(service);
        userMenu2.handleUserInput();
    }
}