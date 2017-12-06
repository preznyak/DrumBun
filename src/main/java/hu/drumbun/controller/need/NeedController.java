package hu.drumbun.controller.need;

import hu.drumbun.controller.need.model.NeedModel;
import hu.drumbun.service.need.NeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/needs")
public class NeedController {

    @Autowired
    NeedService needService;

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

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, value = "/new")
    void createNeed(@RequestBody NeedModel needModel){
        needService.createNeed(needModel);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/takeOffer/{offerId}/{needId}")
    public ResponseEntity<?> takeAnOffer(@PathVariable long offerId, @PathVariable long needId){
        needService.receiveOffer(offerId,needId);
        return new ResponseEntity<>("Offer taken.", HttpStatus.OK);
    }

}
