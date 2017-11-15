package hu.drumbun.controller;

import hu.drumbun.entities.User;
import hu.drumbun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE,value = "/users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/users/{id}")
    public User getUserById(@PathVariable long id){
        return userService.getUserById(id);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, value = "/registeruser")
    public String addUser(@RequestBody User user){
        userService.addUser(new User(user.getEmail(),user.getPassword()));

        return "User added to DB!";
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, value = "/addfuser")
    public String addForeignUser(@RequestBody User user){
        userService.addUser(new User(user.getEmail(),user.getPassword(),user.getOauth_provider(),user.getOauth_uid()));
        return "User added to DB!";
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{id}")
    public String deleteUserById(@PathVariable long id){
        userService.removeUserById(id);
        return "User deleted from DB";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/users/{email}")
    public User getUserByEmail(@PathVariable String email){
        return userService.getUserByEmail(email);
    }
}
