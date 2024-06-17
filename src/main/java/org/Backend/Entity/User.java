package org.Backend.Entity;

import java.util.ArrayList;
import java.util.List;

    public class User {
    private String name;
    private List<Account> balance;

    public User(String name) {
        this.name = name;
        this.balance = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Account> getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }
}
