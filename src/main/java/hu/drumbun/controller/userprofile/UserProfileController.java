package hu.drumbun.controller.userprofile;

import hu.drumbun.controller.userprofile.model.UserProfileResponse;
import hu.drumbun.service.userprofile.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}
