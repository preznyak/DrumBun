package hu.drumbun.service.offer.validator;


import hu.drumbun.commons.OfferAndNeedValidator;
import hu.drumbun.commons.Validator;
import hu.drumbun.commons.ValidatorResult;
import hu.drumbun.controller.offer.model.OfferModel;
import hu.drumbun.entities.User;
import hu.drumbun.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CreateOfferModelValidator implements OfferAndNeedValidator<OfferModel> {

    @Autowired
    UserRepository userRepository;

    @Override
    public ValidatorResult validate(OfferModel toValidate, String username) {
        String result = "";
        User user = userRepository.findByUsername(username);
        if(user.getUserProfile().getDriverLicense().toString() == "No"){
            result = result + "You can't create offer without Driver license. ";
        }
        Date date = new Date();
        System.out.println(date);
        if(toValidate.getDate().before(date)){
            result = result + "You can't create offer in the past! .";
        }
        if(!result.equals("")) {
            return new ValidatorResult(false,result);
        }
        return new ValidatorResult(true,result);
    }
}
