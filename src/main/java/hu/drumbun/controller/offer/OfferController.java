package hu.drumbun.controller.offer;

import hu.drumbun.controller.need.model.NeedModel;
import hu.drumbun.controller.offer.model.OfferModel;
import hu.drumbun.service.offer.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/offers")
public class OfferController {

    @Autowired
    OfferService offerService;

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
    void createOffer(@RequestBody OfferModel offerModel, @PathVariable String username){
        offerService.createOffer(offerModel, username);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, value = "/add/{offerId}")
    public ResponseEntity<?> addNewNeedToOffer(@PathVariable long offerId,@RequestBody NeedModel needModel){
        offerService.addNeed(offerId,needModel);
        return new ResponseEntity<>("Offer added.", HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/joinOffer/{offerId}/{username}")
    public ResponseEntity<?> joinToOffer(@PathVariable long offerId, @PathVariable String username){
        offerService.joinToOffer(offerId,username);
        return new ResponseEntity<>("Joined successfully.",HttpStatus.OK);
    }
}
