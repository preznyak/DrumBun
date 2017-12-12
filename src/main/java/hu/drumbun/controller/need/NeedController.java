package hu.drumbun.controller.need;

import hu.drumbun.commons.ValidatorResult;
import hu.drumbun.controller.need.model.NeedModel;
import hu.drumbun.service.need.NeedService;
import hu.drumbun.service.need.validator.CreateNeedRequestValidator;
import hu.drumbun.service.need.validator.TakeOfferRequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.method.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/needs")
public class NeedController {

    private final NeedService needService;
    private final TakeOfferRequestValidator takeOfferRequestValidator;
    private final CreateNeedRequestValidator createNeedRequestValidator;

    @Autowired
    public NeedController(NeedService needService, TakeOfferRequestValidator takeOfferRequestValidator, CreateNeedRequestValidator createNeedRequestValidator) {
        this.needService = needService;
        this.takeOfferRequestValidator = takeOfferRequestValidator;
        this.createNeedRequestValidator = createNeedRequestValidator;
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<NeedModel> findAllNeeds(){
        return needService.findAll();
    }

    @RequestMapping(method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE, value = "/{id}")
    public NeedModel findNeedById(@PathVariable long id){
        return needService.findById(id);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/dest/{destination}")
    List<NeedModel> findByPath_Destination(@PathVariable String destination){
        return needService.findByPath_Destination(destination);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/start/{start}")
    List<NeedModel> findByPath_Start(@PathVariable String start){
        return needService.findByPath_Start(start);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, value = "/update")
    void updateNeed(@RequestBody NeedModel needModel){
        needService.updateNeed(needModel);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, value = "/new/{username}")
    public ResponseEntity<?> createNeed(@RequestBody NeedModel needModel, @PathVariable String username){
        ValidatorResult result = createNeedRequestValidator.validate(needModel, username);
        if(result.isValid()){
            needService.createNeed(needModel,username);
            return new ResponseEntity<>("Need created.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>(result.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/takeOffer/{needId}/{username}")
    public ResponseEntity<?> takeAnOffer(@PathVariable long needId,@PathVariable String username){
        ValidatorResult result = takeOfferRequestValidator.validate(needService.findById(needId),username);
        if(result.isValid()){
            needService.receiveOffer(needId,username);
            return new ResponseEntity<>("Offer taken.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>(result.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/find/{start}/{destination}/{date}")
    public ResponseEntity<?> findByAll(@PathVariable String start, @PathVariable String destination, @PathVariable String date){
        List<NeedModel> needModels = needService.findByAll(start,destination,date);
        if(needModels.isEmpty()){
            return new ResponseEntity<>("No need found. ", HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(needModels, HttpStatus.OK);
        }
    }

}
