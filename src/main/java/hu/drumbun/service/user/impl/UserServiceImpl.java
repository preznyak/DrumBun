package hu.drumbun.service.user.impl;

import hu.drumbun.controller.user.model.CreateUserRequest;
import hu.drumbun.controller.user.model.UpdateUserRequest;
import hu.drumbun.controller.user.model.UserResponse;
import hu.drumbun.entities.User;
import hu.drumbun.entities.UserProfile;
import hu.drumbun.repository.user.UserRepository;
import hu.drumbun.repository.userprofile.UserProfileRepository;
import hu.drumbun.service.user.UserService;
import hu.drumbun.service.user.converter.CreateUserRequestConverter;
import hu.drumbun.service.user.converter.UpdateUserRequestConverter;
import hu.drumbun.service.user.converter.UserResponseConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Qualifier("userService")
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserProfileRepository userProfileRepository;
    private final CreateUserRequestConverter createUserRequestConverter;
    private final UpdateUserRequestConverter updateUserRequestConverter;
    private final UserResponseConverter userResponseConverter;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserProfileRepository userProfileRepository, CreateUserRequestConverter createUserRequestConverter, UpdateUserRequestConverter updateUserRequestConverter, UserResponseConverter userResponseConverter) {
        this.userRepository = userRepository;
        this.userProfileRepository = userProfileRepository;
        this.createUserRequestConverter = createUserRequestConverter;
        this.updateUserRequestConverter = updateUserRequestConverter;
        this.userResponseConverter = userResponseConverter;
    }

    @Override
    public List<UserResponse> getAllUsers() {
        return userRepository.findAll().stream()
                .map(userResponseConverter::from)
                .collect(Collectors.toList());
    }

    @Override
    public UserResponse getUserById(long id) {
        return userResponseConverter.from(userRepository.findById(id));
    }

    @Override
    public UserResponse getUserByEmail(String email) {
        return userResponseConverter.from(userRepository.findByEmail(email));
    }

    @Override
    public void removeUserById(long id) {
        userRepository.delete(id);
    }


    @Override
    public void addUser(CreateUserRequest createUserRequest) {
        User user = createUserRequestConverter.from(createUserRequest);
        userRepository.save(new User(user.getUsername(),user.getFirstName(),user.getLastName(),user.getEmail(),user.getPassword()));
    }


    @Override
    public void updateUser(UpdateUserRequest updateUserRequest) {
        User updatedUser = updateUserRequestConverter.from(updateUserRequest);
        User oldUser = userRepository.findByUsername(updatedUser.getUsername());
        oldUser.setFirstName(updatedUser.getFirstName());
        oldUser.setLastName(updatedUser.getLastName());
        oldUser.setEmail(updatedUser.getEmail());
        if(userProfileRepository.findByFacebookProfile(updatedUser.getUserProfile().getFacebookProfile())==null){
            UserProfile newUserProfile = updatedUser.getUserProfile();
            userProfileRepository.save(
                    new UserProfile(newUserProfile.getBirthDate(), newUserProfile.getGender(), newUserProfile.getDriverLicense(),
                        newUserProfile.getImage(), newUserProfile.getBio(), newUserProfile.getPhoneNumber(),
                        newUserProfile.getFacebookProfile(), newUserProfile.getCity(), newUserProfile.getCountry()));
            oldUser.setUserProfile(userProfileRepository.findByFacebookProfile(updatedUser.getUserProfile().getFacebookProfile()));
        } else {
                UserProfile userProfile = userProfileRepository.findByFacebookProfile(updateUserRequest.getUserProfile().getFacebookProfile());
                UserProfile updatedUserProfile = updateUserRequest.getUserProfile();
                userProfile.setDriverLicense(updatedUserProfile.getDriverLicense());
                userProfile.setGender(updatedUserProfile.getGender());
                userProfile.setBirthDate(updatedUserProfile.getBirthDate());
                userProfile.setBio(updatedUserProfile.getBio());
                userProfile.setCity(updatedUserProfile.getCity());
                userProfile.setCountry(updatedUserProfile.getCountry());
                userProfile.setImage(updatedUserProfile.getImage());
                userProfile.setPhoneNumber(updatedUserProfile.getPhoneNumber());
                userProfile.setFacebookProfile(updatedUserProfile.getFacebookProfile());
                userProfileRepository.save(userProfile);
        }

        userRepository.save(oldUser);
    }

    @Override
    public User findUserByUserProfileId(long id) {
        return userRepository.findByUserProfileId(id);
    }

    @Override
    public void registerUser(CreateUserRequest createUserRequest) {
        User user = createUserRequestConverter.from(createUserRequest);
        userRepository.save(new User(user.getUsername(),user.getPassword()));
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public UserResponse findUserResponseByUsername(String username) {
        return userResponseConverter.from(userRepository.findByUsername(username));
    }
}
