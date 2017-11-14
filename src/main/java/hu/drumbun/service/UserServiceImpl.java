package hu.drumbun.service;

import hu.drumbun.entities.User;
import hu.drumbun.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public String removeUserById(long id) {
        userRepository.delete(id);
        return "User deleted";
    }


    @Override
    public String addUser(User user) {
        userRepository.save(user);
        return "User added to db";
    }
}
