package org.FrontEnd;

import org.Backend.DTO.CreateTransactionWithComment;
import org.Backend.DTO.RequestCreateUser;
import org.Backend.Entity.Account;
import org.Backend.Entity.Category;
import org.Backend.Entity.Transaction;
import org.Backend.Entity.TransactionType;
import org.Backend.Repository.AccountRepository;
import org.Backend.Repository.UserRepository;
import org.Backend.Service.TransactionBalanceAcountService;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class UserMenu2 {
    private final TransactionBalanceAcountService transactionService;
    private Scanner scanner;

    public UserMenu2(TransactionBalanceAcountService transactionService) {
        this.transactionService = transactionService;
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("Select an option:");
        System.out.println("1. Deposit (DEPOSIT)");
        System.out.println("2. Transfer (TRANSFER)");
        System.out.println("3. Withdrawal (WITHDRAWAL)");
        System.out.println("4. Show transactions by date range");
        System.out.println("5. Show transactions by date");
        System.out.println("6. Create new account");
        System.out.println("7. Create new user");
        System.out.println("0. Exit");
    }

    public void handleUserInput() {
        Boolean conti = true;
        while (conti){
            displayMenu();
            System.out.println("Enter your option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    processTransaction(TransactionType.DEPOSIT);
                    break;
                case 2:
                    processTransaction(TransactionType.TRANSFER);
                    break;
                case 3:
                    processTransaction(TransactionType.WITHDRAWAL);
                    break;
                case 4:
                    searchTransactionsByDateRange();
                    break;
                case 5:
                    searchTransactionsByDate();
                    break;
                case 6:
                    createAccount();
                    break;
                case 7:
                    addNewUser();
                    break;
                case 0:
                    System.out.println("Exiting program.");
                    conti = false;
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void addNewUser() {
        Scanner scanner = new Scanner(System.in);
        UserRepository users = new UserRepository();
        System.out.println("Enter name: ");
        String name = scanner.nextLine();

        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Enter password: ");
        String password = scanner1.nextLine();
        users.addNewUser(new RequestCreateUser(name, password));
        System.out.println("User was added");
    }

    private void processTransaction(TransactionType transactionType) {
        System.out.println("Enter amount:");
        Double amount = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Enter category (SALARY, BONUS, FOOD, CLOTHING, TRANSPORTATION, HOUSING)");
        String categoryStr = scanner.nextLine();
        Category category = null;
        switch (categoryStr.toUpperCase()) {
            case "SALARY":
                category = Category.SALARY;
                break;
            case "BONUS":
                category = Category.BONUS;
                break;
            case "FOOD":
                category = Category.FOOD;
                break;
            case "CLOTHING":
                category = Category.CLOTHING;
                break;
            case "TRANSPORTATION":
                category = Category.TRANSPORTATION;
                break;
            case "HOUSING":
                category = Category.HOUSING;
                break;
            default:
                System.out.println("There is no such category");
                break;
        }

        System.out.println("Enter account ID:");
        Integer accountId = scanner.nextInt();

        System.out.println("Enter comment: ");
        String comment = scanner.nextLine();

        Transaction transaction = new Transaction(transactionType, amount, category, comment);
        transaction.setTransactionNumber(accountId);
        transactionService.updateAccountBalance(transaction);
        if (transactionType.equals(TransactionType.DEPOSIT) || transactionType.equals(TransactionType.WITHDRAWAL)){
            transactionService.
                    add(new CreateTransactionWithComment(transactionType, accountId, amount,category, comment));
        }
        if (transactionType.equals(TransactionType.TRANSFER)){
                System.out.println("Enter id to which account you want to sent money: ");
                Integer idToAccount = scanner.nextInt();
                transactionService.add(new CreateTransactionWithComment(
                transactionType, accountId, idToAccount, amount,category, comment));
        }

    }

    private void searchTransactionsByDateRange() {
        System.out.println("Enter start date (yyyy-MM-dd):");
        LocalDate startDate = LocalDate.parse(scanner.nextLine());

        System.out.println("Enter end date (yyyy-MM-dd):");
        LocalDate endDate = LocalDate.parse(scanner.nextLine());

        List<Transaction> transactions = transactionService.findByDateRange(startDate, endDate).getResponseInfo();
        displayTransactions(transactions);
    }

    private void searchTransactionsByDate() {
        System.out.println("Enter date (yyyy-MM-dd):");
        LocalDate date = LocalDate.parse(scanner.nextLine());

        List<Transaction> transactions = transactionService.findByDate(date).getResponseInfo();
        displayTransactions(transactions);
    }

    private void displayTransactions(List<Transaction> transactions) {
        if (transactions.isEmpty()) {
            System.out.println("No transactions found.");
        } else {
            for (Transaction transaction : transactions) {
                System.out.println(transaction);
            }
        }
    }

    private void createAccount() {
        System.out.println("Enter account name:");
        Scanner scr = new Scanner(System.in);
        String name = scr.nextLine();
        System.out.println("Enter account id:");
        Integer id = scr.nextInt();
        Double total = 20000000.0;
        AccountRepository repository = new AccountRepository();
        Account account = new Account(id,name,total);
        repository.addNewAccount(account);
        // Call createAccount method in service
        System.out.println(account);
    }
}
