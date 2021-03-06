package hu.drumbun.service.userprofile;

import hu.drumbun.controller.userprofile.model.CreateUserProfileRequest;
import hu.drumbun.controller.userprofile.model.UpdateUserProfileRequest;
import hu.drumbun.controller.userprofile.model.UserProfileResponse;
import hu.drumbun.enums.DriverLicense;
import hu.drumbun.enums.Gender;

import java.util.List;

public interface UserProfileService {

    List<UserProfileResponse> findAll();

    List<UserProfileResponse> findAllByDriverLicense(DriverLicense driverLicense);

    List<UserProfileResponse> findAllByGender(Gender gender);

    void createUserProfile(CreateUserProfileRequest createUserProfileRequest);

    void updateUserProfile(UpdateUserProfileRequest updateUserProfileRequest);

    void deleteUserProfileById(long id);

}
