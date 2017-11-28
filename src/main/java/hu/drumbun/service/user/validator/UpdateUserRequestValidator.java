package hu.drumbun.service.user.validator;

import hu.drumbun.commons.Validator;
import hu.drumbun.commons.ValidatorResult;
import hu.drumbun.controller.user.model.UpdateUserRequest;
import hu.drumbun.entities.User;
import hu.drumbun.entities.UserProfile;
import hu.drumbun.repository.user.UserRepository;
import hu.drumbun.repository.userprofile.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateUserRequestValidator implements Validator<UpdateUserRequest> {

    private UserProfileRepository userProfileRepository;
    private UserRepository userRepository;

    @Autowired
    public UpdateUserRequestValidator(UserProfileRepository userProfileRepository, UserRepository userRepository) {
        this.userProfileRepository = userProfileRepository;
        this.userRepository = userRepository;
    }

    @Override
    public ValidatorResult validate(UpdateUserRequest toValidate) {
        String result = "";
        if(toValidate.getUsername() == null || toValidate.getUsername().equals("")){
            result = result + "Username must not be empty or null. ";
        }
        if(toValidate.getPassword() == null || toValidate.getPassword().equals("")){
            result = result + "Password must not be empty or null. ";
        }
        if(toValidate.getUserProfile().getFacebookProfile().equals("") || toValidate.getUserProfile().getFacebookProfile().equals(null)){
            result = result + "Facebook profile must not be null.";
        }
        UserProfile usersProfile = userProfileRepository.findByFacebookProfile(toValidate.getUserProfile().getFacebookProfile());
        if(usersProfile != null){
            User userForUpdate = userRepository.findByUsername(toValidate.getUsername());
            if(usersProfile.getId() != userForUpdate.getUserProfile().getId()){
                result = result + "Invalid operation. ";
            }
        }

        if(!result.equals("")){
            return new ValidatorResult(false, result);
        } else {
            return new ValidatorResult(true, result);
        }
    }
}
