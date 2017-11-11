package hu.drumbun.repository;

import hu.drumbun.entities.User;

import java.util.List;

public interface UserDao {

    User getUserById(long id);

    List<User> getAllUser();

    void removeUserById(long id);

    void updateUser(User user);

    void addUser(User user);

}
