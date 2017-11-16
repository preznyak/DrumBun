package hu.drumbun.controller.user;

import hu.drumbun.controller.user.model.CreateUserRequest;
import hu.drumbun.controller.user.model.UpdateUserRequest;
import hu.drumbun.controller.user.model.UserResponse;
import hu.drumbun.entities.User;
import hu.drumbun.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    @Qualifier("userService")
    UserService userService;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserResponse> getAllUsers() {
        return userService.getAllUsers();
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/{id}")
    public UserResponse getUserById(@PathVariable long id) {

        System.out.println(id);
        return userService.getUserById(id);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, value = "/adduser")
    public String addUser(@RequestBody CreateUserRequest createUserRequest) {
        userService.addUser(new CreateUserRequest(createUserRequest.getFirstName(),createUserRequest.getLastName(),createUserRequest.getEmail(),createUserRequest.getPassword()));
        return "User added to DB!";
    }


    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{id}")
    public String deleteUserById(@PathVariable long id) {
        userService.removeUserById(id);
        return "User deleted from DB";
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/update")
    public String updateUser(@RequestBody UpdateUserRequest updateUserRequest){
        userService.updateUser(updateUserRequest);
        return "User updated";
    }

}
