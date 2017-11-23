package hu.drumbun.service.userprofile.impl;

import hu.drumbun.controller.userprofile.model.CreateUserProfileRequest;
import hu.drumbun.controller.userprofile.model.UpdateUserProfileRequest;
import hu.drumbun.controller.userprofile.model.UserProfileResponse;
import hu.drumbun.entities.User;
import hu.drumbun.entities.UserProfile;
import hu.drumbun.enums.DriverLicense;
import hu.drumbun.enums.Gender;
import hu.drumbun.repository.user.UserRepository;
import hu.drumbun.repository.userprofile.UserProfileRepository;
import hu.drumbun.service.userprofile.UserProfileService;
import hu.drumbun.service.userprofile.converter.CreateUserProfileRequestConverter;
import hu.drumbun.service.userprofile.converter.UpdateUserProfileRequestConverter;
import hu.drumbun.service.userprofile.converter.UserProfileResponseConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Qualifier("userProfileService")
public class UserProfileServiceImpl implements UserProfileService{

    private final UserProfileRepository userProfileRepository;
    private final UserRepository userRepository;
    private final CreateUserProfileRequestConverter createUserProfileRequestConverter;
    private final UpdateUserProfileRequestConverter updateUserProfileRequestConverter;
    private final UserProfileResponseConverter userProfileResponseConverter;

    @Autowired
    public UserProfileServiceImpl(UserProfileRepository userProfileRepository, UserRepository userRepository, CreateUserProfileRequestConverter createUserProfileRequestConverter, UpdateUserProfileRequestConverter updateUserProfileRequestConverter, UserProfileResponseConverter userProfileResponseConverter) {
        this.userProfileRepository = userProfileRepository;
        this.userRepository = userRepository;
        this.createUserProfileRequestConverter = createUserProfileRequestConverter;
        this.updateUserProfileRequestConverter = updateUserProfileRequestConverter;
        this.userProfileResponseConverter = userProfileResponseConverter;
    }

    @Override
    public List<UserProfileResponse> findAll() {
        return userProfileRepository.findAll().stream()
                .map(userProfileResponseConverter::from)
                .collect(Collectors.toList());
    }

    @Override
    public List<UserProfileResponse> findAllByDriverLicense(DriverLicense driverLicense) {
        return userProfileRepository.findAllByDriverLicense(driverLicense).stream()
                .map(userProfileResponseConverter::from)
                .collect(Collectors.toList());
    }

    @Override
    public List<UserProfileResponse> findAllByGender(Gender gender) {
        return userProfileRepository.findAllByGender(gender).stream()
                .map(userProfileResponseConverter::from)
                .collect(Collectors.toList());
    }

    @Override
    public void createUserProfile(CreateUserProfileRequest createUserProfileRequest) {
        UserProfile userProfile = createUserProfileRequestConverter.from(createUserProfileRequest);
        userProfileRepository.save(new UserProfile(userProfile.getBirthDate(),userProfile.getGender(),userProfile.getDriverLicense(), userProfile.getImage(), userProfile.getBio(),userProfile.getPhoneNumber(),userProfile.getFacebookProfile(),userProfile.getCity(),userProfile.getCountry()));
    }

    @Override
    public void updateUserProfile(UpdateUserProfileRequest updateUserProfileRequest) {
        UserProfile updatedUserProfile = updateUserProfileRequestConverter.from(updateUserProfileRequest);
        UserProfile oldUserProfile = userProfileRepository.findOne(updatedUserProfile.getId());
        oldUserProfile.setBirthDate(updatedUserProfile.getBirthDate());
        oldUserProfile.setGender(updatedUserProfile.getGender());
        oldUserProfile.setDriverLicense(updatedUserProfile.getDriverLicense());
        userProfileRepository.save(oldUserProfile);
    }

    @Override
    public void deleteUserProfileById(long id) {
        User userWithThisProfile = userRepository.findByUserProfileId(id);
        if(userWithThisProfile != null) {
            userWithThisProfile.setUserProfile(null);
            userRepository.save(userWithThisProfile);
            userProfileRepository.delete(id);
        }
        else {
            userProfileRepository.delete(id);
        }
    }
}
