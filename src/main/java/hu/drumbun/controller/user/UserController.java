package hu.drumbun.controller.user;

import hu.drumbun.commons.ValidatorResult;
import hu.drumbun.controller.user.model.CreateUserRequest;
import hu.drumbun.controller.user.model.UpdateUserRequest;
import hu.drumbun.service.user.UserService;
import hu.drumbun.service.user.validator.CreateUserRequestValidator;
import hu.drumbun.service.user.validator.UpdateUserRequestValidator;
import hu.drumbun.service.userprofile.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
public class UserController {

    private UserService userService;
    private UserProfileService userProfileService;
    private CreateUserRequestValidator createUserRequestValidator;
    private UpdateUserRequestValidator updateUserRequestValidator;

    public UserController() {
    }

    @Autowired
    public UserController(UserService userService, UserProfileService userProfileService, CreateUserRequestValidator createUserRequestValidator, UpdateUserRequestValidator updateUserRequestValidator) {
        this.userService = userService;
        this.userProfileService = userProfileService;
        this.createUserRequestValidator = createUserRequestValidator;
        this.updateUserRequestValidator = updateUserRequestValidator;
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
        ValidatorResult validatorResult = createUserRequestValidator.validate(createUserRequest);
        if(validatorResult.isValid()){
            userService.addUser(new CreateUserRequest(createUserRequest.getUsername(),createUserRequest.getFirstName(), createUserRequest.getLastName(), createUserRequest.getEmail(), createUserRequest.getPassword(), createUserRequest.getConfirmPassword()));
            return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(validatorResult.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


    @RequestMapping(method = RequestMethod.DELETE, value = "users/delete/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable long id) {
        userService.removeUserById(id);
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "users/update")
    public ResponseEntity<?> updateUser(@RequestBody UpdateUserRequest updateUserRequest) {
        ValidatorResult validatorResult = updateUserRequestValidator.validate(updateUserRequest);
        if(validatorResult.isValid()){
            userService.updateUser(updateUserRequest);
            return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(validatorResult.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
