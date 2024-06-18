package org.Backend.Entity;

import java.util.ArrayList;
import java.util.List;

    public class User {
    private String name;
    private String password;
    private List<Account> balance;

        public User(String name, String password) {
            this.name = name;
            this.password = password;
            this.balance = new ArrayList<>();
        }

        public String getName() {
        return name;
    }

        public List<Account> getBalance() {
        return balance;
    }

        public String getPassword() {
            return password;
        }

        @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }
}
