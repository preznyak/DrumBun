package hu.drumbun.controller.user;

import hu.drumbun.controller.user.model.CreateUserRequest;
import hu.drumbun.controller.user.model.UpdateUserRequest;
import hu.drumbun.controller.user.model.UserResponse;
import hu.drumbun.entities.User;
import hu.drumbun.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserController {

    @Autowired
    @Qualifier("userService")
    UserService userService;

    public UserController() {
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/users")
    public List<UserResponse> getAllUsers() {
        return userService.getAllUsers();
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/users/id/{id}")
    public UserResponse getUserById(@PathVariable long id) {

        System.out.println(id);
        return userService.getUserById(id);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/users/username/{username}")
    public UserResponse getUserById(@PathVariable String username) {
        return userService.findUserResponseByUsername(username);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, value = "/registeruser")
    public String addUser(@RequestBody CreateUserRequest createUserRequest) {
        userService.addUser(new CreateUserRequest(createUserRequest.getUsername(),createUserRequest.getFirstName(), createUserRequest.getLastName(), createUserRequest.getEmail(), createUserRequest.getPassword(), createUserRequest.getConfirmPassword()));
        return "User registered!";
    }


    @RequestMapping(method = RequestMethod.DELETE, value = "users/delete/{id}")
    public String deleteUserById(@PathVariable long id) {
        userService.removeUserById(id);
        return "User deleted from DB";
    }

    @RequestMapping(method = RequestMethod.PUT, value = "users/update")
    public String updateUser(@RequestBody UpdateUserRequest updateUserRequest) {
        userService.updateUser(updateUserRequest);
        return "User updated";
    }

}
