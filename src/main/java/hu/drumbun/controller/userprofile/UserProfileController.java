package hu.drumbun.controller.userprofile;

import hu.drumbun.controller.userprofile.model.CreateUserProfileRequest;
import hu.drumbun.controller.userprofile.model.UpdateUserProfileRequest;
import hu.drumbun.enums.DriverLicense;
import hu.drumbun.enums.Gender;
import hu.drumbun.service.userprofile.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/userprofile")
public class UserProfileController {

    @Autowired
    @Qualifier("userProfileService")
    UserProfileService userProfileService;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllUsers() {
        return new ResponseEntity<>(userProfileService.findAll(), HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/{driverLicense}")
    public ResponseEntity<?> findAllByDriverLicense(@PathVariable DriverLicense driverLicense){
        return new ResponseEntity<>(userProfileService.findAllByDriverLicense(driverLicense), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/{gender}")
    public ResponseEntity<?> findAllByGender(@PathVariable Gender gender){
        return new ResponseEntity<>(userProfileService.findAllByGender(gender), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, value = "/create")
    public ResponseEntity<?> createUserProfile(@RequestBody CreateUserProfileRequest createUserProfileRequest){
        userProfileService.createUserProfile(createUserProfileRequest);
        return  new ResponseEntity<>(userProfileService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, value = "/update")
    public ResponseEntity<?> updateUserProfile(@RequestBody UpdateUserProfileRequest updateUserProfileRequest){
        userProfileService.updateUserProfile(updateUserProfileRequest);
        return new ResponseEntity<>(userProfileService.findAll(),HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{id}")
    public ResponseEntity<?> deleteUserProfileById(@PathVariable long id){
        userProfileService.deleteUserProfileById(id);
        return new ResponseEntity<>(userProfileService.findAll(), HttpStatus.OK);
    }
}
