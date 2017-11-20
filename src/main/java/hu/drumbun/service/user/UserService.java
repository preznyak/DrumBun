package hu.drumbun.service.user;

import hu.drumbun.controller.user.model.CreateUserRequest;
import hu.drumbun.controller.user.model.UpdateUserRequest;
import hu.drumbun.controller.user.model.UserResponse;
import hu.drumbun.entities.User;

import java.util.List;


public interface UserService {
    List<UserResponse> getAllUsers();

    UserResponse getUserById(long id);

    UserResponse getUserByEmail(String email);

    void removeUserById(long id);

    void addUser(CreateUserRequest createUserRequest);

    void updateUser(UpdateUserRequest updateUserRequest);

    User findUserByUserProfileId(long id);

    void registerUser(CreateUserRequest createUserRequest);
}
