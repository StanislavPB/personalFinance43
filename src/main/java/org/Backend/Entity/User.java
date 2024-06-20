package org.Backend.Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

        public List<Account> addNewAccount(Account account){
            balance.add(account);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) && Objects.equals(password, user.password) && Objects.equals(balance, user.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, password, balance);
    }
}
