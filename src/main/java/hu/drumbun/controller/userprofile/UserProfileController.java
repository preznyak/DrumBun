package hu.drumbun.controller.userprofile;

import hu.drumbun.controller.userprofile.model.CreateUserProfileRequest;
import hu.drumbun.controller.userprofile.model.UpdateUserProfileRequest;
import hu.drumbun.controller.userprofile.model.UserProfileResponse;
import hu.drumbun.enums.DriverLicense;
import hu.drumbun.enums.Gender;
import hu.drumbun.service.userprofile.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.MediaPrintableArea;
import java.util.List;

@RestController
@RequestMapping("/userprofile")
public class UserProfileController {

    @Autowired
    @Qualifier("userProfileService")
    UserProfileService userProfileService;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserProfileResponse> getAllUsers() {
        return userProfileService.findAll();
    }


    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/{driverLicense}")
    public List<UserProfileResponse> findAllByDriverLicense(@PathVariable DriverLicense driverLicense){
        return userProfileService.findAllByDriverLicense(driverLicense);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/{gender}")
    public List<UserProfileResponse> findAllByGender(@PathVariable Gender gender){
        return userProfileService.findAllByGender(gender);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, value = "/create")
    public void createUserProfile(@RequestBody CreateUserProfileRequest createUserProfileRequest){
        userProfileService.createUserProfile(createUserProfileRequest);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, value = "/update")
    public void updateUserProfile(@RequestBody UpdateUserProfileRequest updateUserProfileRequest){
        userProfileService.updateUserProfile(updateUserProfileRequest);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{id}")
    public void deleteUserProfileById(@PathVariable long id){
        userProfileService.deleteUserProfileById(id);
    }
}
