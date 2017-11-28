package hu.drumbun.service.user.validator;

import hu.drumbun.commons.Validator;
import hu.drumbun.commons.ValidatorResult;
import hu.drumbun.controller.user.model.CreateUserRequest;
import hu.drumbun.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateUserRequestValidator implements Validator<CreateUserRequest> {
    @Autowired
    UserRepository userRepository;

    @Override
    public ValidatorResult validate(CreateUserRequest toValidate) {

        String result = "";
        if(toValidate.getUsername() == null || toValidate.getUsername().equals("")){
            result = result + "Username must not be empty. ";
        }
        if(userRepository.findByUsername(toValidate.getUsername())!=null){
            result = result + "Username already exists. ";
        }
        if(userRepository.findByEmail(toValidate.getEmail())!=null){
            result = result + "Email address already in use. ";
        }
        if(toValidate.getPassword() == null || toValidate.getPassword().equals("")){
            result = result + "Password must not be null. ";
        }
        if(!result.equals("")) {
            return new ValidatorResult(false,result);
        }
        return new ValidatorResult(true,result);
    }
}
