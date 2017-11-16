package hu.drumbun.service.user.impl;

import hu.drumbun.controller.user.model.CreateUserRequest;
import hu.drumbun.controller.user.model.UpdateUserRequest;
import hu.drumbun.controller.user.model.UserResponse;
import hu.drumbun.entities.User;
import hu.drumbun.repository.user.UserRepository;
import hu.drumbun.service.user.UserService;
import hu.drumbun.service.user.converter.CreateUserRequestConverter;
import hu.drumbun.service.user.converter.UpdateUserRequestConverter;
import hu.drumbun.service.user.converter.UserResponseConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Qualifier("userService")
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final CreateUserRequestConverter createUserRequestConverter;
    private final UpdateUserRequestConverter updateUserRequestConverter;
    private final UserResponseConverter userResponseConverter;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, CreateUserRequestConverter createUserRequestConverter, UpdateUserRequestConverter updateUserRequestConverter, UserResponseConverter userResponseConverter) {
        this.userRepository = userRepository;
        this.createUserRequestConverter = createUserRequestConverter;
        this.updateUserRequestConverter = updateUserRequestConverter;
        this.userResponseConverter = userResponseConverter;
    }

    @Override
    public List<UserResponse> getAllUsers() {
        return userRepository.findAll().stream()
                .map(userResponseConverter::from)
                .collect(Collectors.toList());
    }

    @Override
    public UserResponse getUserById(long id) {
        return userResponseConverter.from(userRepository.findById(id));
    }

    @Override
    public UserResponse getUserByEmail(String email) {
        return userResponseConverter.from(userRepository.findByEmail(email));
    }

    @Override
    public void removeUserById(long id) {
        userRepository.delete(id);
    }


    @Override
    public void addUser(CreateUserRequest createUserRequest) {
        User user = createUserRequestConverter.from(createUserRequest);
        userRepository.save(new User(user.getFirstName(),user.getLastName(),user.getEmail(),user.getPassword()));
    }

    @Override
    public void updateUser(UpdateUserRequest updateUserRequest) {
        User updatedUser = updateUserRequestConverter.from(updateUserRequest);
        User oldUser = userRepository.findById(updatedUser.getId());
        oldUser.setFirstName(updatedUser.getFirstName());
        oldUser.setLastName(updatedUser.getLastName());
        oldUser.setEmail(updatedUser.getEmail());
        oldUser.setPassword(updatedUser.getPassword());
        oldUser.setOauth_provider(updatedUser.getOauth_provider());
        oldUser.setOauth_uid(updatedUser.getOauth_uid());
        oldUser.setUserProfile(updatedUser.getUserProfile());
        userRepository.save(oldUser);
    }
}
