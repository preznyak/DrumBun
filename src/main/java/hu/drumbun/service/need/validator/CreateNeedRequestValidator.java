package hu.drumbun.service.need.validator;

import hu.drumbun.commons.OfferAndNeedValidator;
import hu.drumbun.commons.ValidatorResult;
import hu.drumbun.controller.need.model.NeedModel;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CreateNeedRequestValidator implements OfferAndNeedValidator<NeedModel> {
    @Override
    public ValidatorResult validate(NeedModel toValidate, String username) {
        String result = "";
        Date date = new Date();
        if(toValidate.getDate().before(date)){
            result = result + "You can't create need in the past!";
        }
        if(!result.equals("")) {
            return new ValidatorResult(false,result);
        }
        return new ValidatorResult(true,result);
    }
}
