package hu.drumbun.service;

import hu.drumbun.entities.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User getUserById(long id);

    String removeUserById(long id);

    String addUser(User user);
}
