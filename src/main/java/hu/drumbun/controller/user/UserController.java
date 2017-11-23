package hu.drumbun.controller.user;

import hu.drumbun.controller.user.model.CreateUserRequest;
import hu.drumbun.controller.user.model.UpdateUserRequest;
import hu.drumbun.controller.user.model.UserResponse;
import hu.drumbun.entities.User;
import hu.drumbun.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class UserController {

    @Autowired
    @Qualifier("userService")
    UserService userService;

    public UserController() {
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/users")
    public ResponseEntity<?> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/users/id/{id}")
    public ResponseEntity<?> getUserById(@PathVariable long id) {
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/users/username/{username}")
    public ResponseEntity<?> getUserById(@PathVariable String username) {
        return new ResponseEntity<>(userService.findUserResponseByUsername(username),HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, value = "/registeruser")
    public ResponseEntity<?> addUser(@RequestBody CreateUserRequest createUserRequest) {
        userService.addUser(new CreateUserRequest(createUserRequest.getUsername(),createUserRequest.getFirstName(), createUserRequest.getLastName(), createUserRequest.getEmail(), createUserRequest.getPassword(), createUserRequest.getConfirmPassword()));
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.DELETE, value = "users/delete/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable long id) {
        userService.removeUserById(id);
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "users/update")
    public ResponseEntity<?> updateUser(@RequestBody UpdateUserRequest updateUserRequest) {
        userService.updateUser(updateUserRequest);
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

}
