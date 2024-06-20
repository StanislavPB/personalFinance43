package org.Backend.Repository;

import org.Backend.DTO.RequestCreateUser;
import org.Backend.Entity.User;
import java.util.Optional;

interface UserRepositoryInterface{
    User addNewUser(RequestCreateUser user);
    boolean removeNewUser(User user);
    Optional<User> findUserByName(String name);
    User addUsertoUsers(User user);
    boolean contains (User user1);
    void findAllUser();
}
