package hu.drumbun.service.need.validator;

import hu.drumbun.commons.OfferAndNeedValidator;
import hu.drumbun.commons.ValidatorResult;
import hu.drumbun.controller.need.model.NeedModel;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class TakeOfferRequestValidator implements OfferAndNeedValidator<NeedModel> {
    @Override
    public ValidatorResult validate(NeedModel toValidate, String username) {
        String result = "";
        if(!toValidate.getTransporters().stream()
                .filter(p->p.getUsername().equals(username))
                .collect(Collectors.toList()).isEmpty()){
            result = result + "You can't offer twice for the same need. ";
        }
        if(!result.equals("")) {
            return new ValidatorResult(false,result);
        }
        return new ValidatorResult(true,result);
    }
}
