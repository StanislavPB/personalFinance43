package org.Backend.Service.Validation;

import org.Backend.DTO.AccountDTO;

import org.Backend.DTO.CreateTransactionWithComment;
import org.Backend.DTO.RequestCreateUser;
import org.Backend.Entity.User;
import org.Backend.Repository.UserRepository;
import org.Backend.Service.TransactionBalanceAcountService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class Validation {

    public  boolean isPasswordCorrect(String userName, String password) { // entered from scanner
        UserRepository users = new UserRepository();
        boolean iscorrect = false;
        User check = new User(userName, password);
        if (users.contains(check)){
            iscorrect = true;
        }
        return iscorrect;
    }
    TransactionBalanceAcountService service = new TransactionBalanceAcountService();

    public boolean checkRequestCreateUser(RequestCreateUser requestCreateUser){
        List<String> errors = new ArrayList<>();
        if (requestCreateUser.getName().isEmpty()) errors.add("User name must not be null \n");
        if (requestCreateUser.getPassword().isEmpty()) errors.add("User password must not be null \n");

        if (requestCreateUser.getName().length() < 2 || requestCreateUser.getName().length() > 20)
            errors.add("User name length must be between 2 and 20 letters \n");
        if (requestCreateUser.getPassword().length() < 6 || requestCreateUser.getPassword().length() > 30)
            errors.add("Password length must be between 6 and 30 letters \n");


        if (errors.isEmpty()) {
            return true;
        } else {
            throw new ValidationException(errors.toString());
        }
    }

    public boolean checkAccountDTO(AccountDTO requestAccount){
        List<String> errors = new ArrayList<>();
        if (requestAccount.getAccountName().isEmpty()) errors.add("User name must not be null \n");
        if (requestAccount.getTotalAmount().isNaN()) errors.add("Total amount must be number with decimal \n");
        if (requestAccount.getTotalAmount() != 0.0) errors.add("Total amount must not be 0 \n");
        if (requestAccount.getAccountName().length() < 5 || requestAccount.getAccountName().length() > 20)
            errors.add("Account name length must be between 2 and 20 letters \n");


        if (errors.isEmpty()) {
            return true;
        } else {
            throw new ValidationException(errors.toString());
        }
    }
    public boolean checkCreateTransaction(CreateTransactionWithComment requestCreateTransaction){
        List<String> errors = new ArrayList<>();
        if (requestCreateTransaction.getType() != null) errors.add("Type must not be null \n");
        if (requestCreateTransaction.getCategory() !=null) errors.add("Category must be chosen \n");
        if (requestCreateTransaction.getAmount().isNaN()) errors.add("Total amount must be number with decimal \n");
        if (requestCreateTransaction.getAmount() != 0) errors.add("Total amount must not be 0 \n");
        if(service.findById(requestCreateTransaction.getFromAccountID()).getTotalAmount() < requestCreateTransaction.getAmount())
            errors.add("Transaction not possible");


        if (errors.isEmpty()) {
            return true;
        } else {
            throw new ValidationException(errors.toString());
        }
    }
}
