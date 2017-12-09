package hu.drumbun.service.offer.validator;

import hu.drumbun.commons.OfferAndNeedValidator;
import hu.drumbun.commons.ValidatorResult;
import hu.drumbun.controller.offer.model.OfferModel;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class JoinOfferValidator implements OfferAndNeedValidator<OfferModel> {
    @Override
    public ValidatorResult validate(OfferModel toValidate, String username) {
        String result = "";
        if(!toValidate.getPassengers().stream()
                .filter(p->p.getUsername().equals(username))
                .collect(Collectors.toList()).isEmpty()){
            result = result + "You're already joined this offer. ";
        }
        if(toValidate.getOccupiedSeats()==toValidate.getMaxSeats()){
            result = result + "All seats are taken. ";
        }
        if(!result.equals("")) {
            return new ValidatorResult(false,result);
        }
        return new ValidatorResult(true,result);
    }
}
