package org.Backend.Repository;

import org.Backend.DTO.RequestCreateUser;
import org.Backend.Entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository implements UserRepositoryInterface{
    List<User> users = new ArrayList<>();
    public List<User> getUsers() {
        return users;
    }
    @Override
    public User addNewUser(RequestCreateUser user) {
        User user1 = new User(user.getName(),user.getPassword());
        if (!users.contains(user1)){
            users.add(user1);
            return user1;
        }
        return user1;
    }

    @Override
    public boolean removeNewUser(User user) {
        return users.remove(user);
    }

    @Override
    public Optional<User> findUserByName(String name) {
        User foundedUser = null;
        for (User user: users){
            if (user.getName().equals(name)){
                foundedUser = user;
            }
        }
        return Optional.ofNullable(foundedUser);
    }

    @Override
    public User addUsertoUsers(User user) {
        if (!users.contains(user)){
            users.add(user);
        }
        return user;
    }

    public boolean contains(User user1){
        return (users.contains(user1));
    }

    @Override
    public void findAllUser() {
        if (users.isEmpty()) {
            System.out.println("Нет зарегистрированных пользователей.");
        } else {
            System.out.println("Список зарегистрированных пользователей:");
            for (User user : users) {
                System.out.println("Имя: " + user.getName());
            }
        }
    }
}
