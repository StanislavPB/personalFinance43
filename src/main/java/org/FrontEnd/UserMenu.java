//package org.FrontEnd;
//
//import org.Backend.Entity.Transaction;
//import org.Backend.Entity.TransactionType;
//import org.Backend.Service.TransactionBalanceAcountService;
//
//import java.time.LocalDate;
//import java.util.List;
//import java.util.Scanner;
//
// class UserMenu {
//    private TransactionBalanceAcountService userService;
//    private  Scanner scanner;
//
//    public UserMenu(TransactionBalanceAcountService userService, Scanner scanner) {
//        this.userService = userService;
//
//    }
//
//
//    public void displayMenu() {
//        System.out.println("Выберите опцию:");
//        System.out.println("1. Пополнение счета (DEPOSIT)");
//        System.out.println("2. Перевод средств (TRANSFER)");
//        System.out.println("3. Снятие средств (WITHDRAWAL)");
//        System.out.println("4. Показать  транзакции за период");
//        System.out.println("5. Добавить новый счет");
//        System.out.println("0. Выход");
//    }
//
//    public void UserInput() {
//        int choice = scanner.nextInt();
//        scanner.nextLine();
//
//        switch (choice) {
//            case 1:
//                processTransaction(TransactionType.DEPOSIT);
//                break;
//            case 2:
//                processTransaction(TransactionType.TRANSFER);
//                break;
//            case 3:
//                processTransaction(TransactionType.WITHDRAWAL);
//                break;
//            case 4:
//                int year = scanner.nextInt();
//                int month = scanner.nextInt();
//                int day = scanner.nextInt();
//                LocalDate date = LocalDate.of(year, month, day);
//                userService.findByDate(date); // поиск по дате
//                break;
//            case 5:
//                createAccount();
//                break;
//            case 0:
//                System.out.println("Выход из программы.");
//                break;
//            default:
//                System.out.println("Неверный выбор. Попробуйте снова.");
//        }
//        }
//    }
//
//    private void processTransaction(TransactionType transactionType) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Введите ID счета:");
//        long accountId = scanner.nextLong();
//        scanner.nextLine();
//
//        System.out.println("Введите сумму:");
//        double amount = scanner.nextDouble();
//        scanner.nextLine();
//
//        if (transactionType == TransactionType.TRANSFER) {
//            System.out.println("Введите ID счета для перевода:");
//            Integer transferAccountId = scanner.nextInt();
//            scanner.nextLine();
//
//            TransactionBalanceAcountService userService = ne
//            (accountId, transferAccountId, amount);
//        } else {
//            userService.processTransaction(transactionType, accountId, amount);
//        }
//    }
//
//    private void displayTransactions() {
//        List<Transaction> transactions = userService.getAllTransactions();
//        for (Transaction transaction : transactions) {
//            System.out.println(transaction);
//        }
//    }
//    private void createAccount() {
//        System.out.println("Введите название нового счета:");
//        String accountName = scanner.nextLine();
//        TransactionBalanceAcountService.createAccount(accountName);
//        System.out.println("Новый счет \"" + accountName + "\" создан.");
//    }
//
//}
