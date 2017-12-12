package hu.drumbun.controller.offer;

import hu.drumbun.commons.ValidatorResult;
import hu.drumbun.controller.offer.model.OfferModel;
import hu.drumbun.service.offer.OfferService;
import hu.drumbun.service.offer.validator.CreateOfferModelValidator;
import hu.drumbun.service.offer.validator.JoinOfferValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/offers")
public class OfferController {


    private final OfferService offerService;
    private final CreateOfferModelValidator createOfferModelValidator;
    private final JoinOfferValidator joinOfferValidator;

    @Autowired
    public OfferController(OfferService offerService, CreateOfferModelValidator createOfferModelValidator, JoinOfferValidator joinOfferValidator) {
        this.offerService = offerService;
        this.createOfferModelValidator = createOfferModelValidator;
        this.joinOfferValidator = joinOfferValidator;
    }

    @RequestMapping(method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findAllOffers(){
        return new ResponseEntity<>(offerService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE,value = "/{id}")
    public ResponseEntity<?> findOfferById(@PathVariable long id){
        return new ResponseEntity<>(offerService.findById(id), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE,value = "/start/{start}")
    public ResponseEntity<?> findByPath_Start(@PathVariable String start){
        return new ResponseEntity<>(offerService.findByPath_Start(start), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE,value = "/dest/{destination}")
    List<OfferModel> findByPath_Destination(@PathVariable String destination){
        return offerService.findByPath_Destination(destination);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, value = "/update")
    void updateOffer(@RequestBody OfferModel offerModel){
        offerService.updateOffer(offerModel);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, value = "/new/{username}")
    public ResponseEntity<?> createOffer(@RequestBody OfferModel offerModel, @PathVariable String username){
        ValidatorResult result = createOfferModelValidator.validate(offerModel,username);
        if(result.isValid()){
            offerService.createOffer(offerModel, username);
            return new ResponseEntity<>("Offer created.",HttpStatus.OK);
        } else {
            return new ResponseEntity<>(result.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/joinOffer/{offerId}/{username}")
    public ResponseEntity<?> joinToOffer(@PathVariable long offerId, @PathVariable String username){
        ValidatorResult result = joinOfferValidator.validate(offerService.findById(offerId),username);
        if(result.isValid()){
            offerService.joinToOffer(offerId,username);
            return new ResponseEntity<>("Joined successfully.",HttpStatus.OK);
        } else {
            return new ResponseEntity<>(result.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/find/{start}/{destination}/{date}")
    public ResponseEntity<?> findOffers(@PathVariable String start, @PathVariable String destination, @PathVariable String date){
        List<OfferModel> foundOffers = offerService.findByAll(start,destination,date);
        if(foundOffers.isEmpty()){
            return new ResponseEntity<>("No offers found. ", HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(offerService.findByAll(start, destination, date), HttpStatus.OK);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{offerId}")
    public ResponseEntity<?> deleteOffer(@PathVariable long offerId){
        offerService.removeOfferById(offerId);
        return new ResponseEntity<>("Offer deleted.", HttpStatus.OK);
    }
}
