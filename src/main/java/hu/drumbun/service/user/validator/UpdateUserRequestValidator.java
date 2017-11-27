package hu.drumbun.service.user.validator;

import hu.drumbun.commons.Validator;
import hu.drumbun.commons.ValidatorResult;
import hu.drumbun.controller.user.model.UpdateUserRequest;
import hu.drumbun.repository.userprofile.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateUserRequestValidator implements Validator<UpdateUserRequest> {

    @Autowired
    UserProfileRepository userProfileRepository;

    @Override
    public ValidatorResult validate(UpdateUserRequest toValidate) {
        String result = "";
        if(toValidate.getUsername() == null || toValidate.getUsername().equals("")){
            result = result + "Username must not be empty or null. ";
        }
        if(toValidate.getPassword() == null || toValidate.getPassword().equals("")){
            result = result + "Password must not be empty or null. ";
        }
        if(!result.equals("")){
            return new ValidatorResult(false, result);
        } else {
            return new ValidatorResult(true, result);
        }
    }
}
