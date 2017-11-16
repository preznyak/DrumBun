package hu.drumbun.controller.offer;

import hu.drumbun.controller.offer.model.OfferModel;
import hu.drumbun.service.offer.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/offers")
public class OfferController {

    @Autowired
    OfferService offerService;

    @RequestMapping(method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OfferModel> findAllOffers(){
        return offerService.findAll();
    }

    @RequestMapping(method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE,value = "/{id}")
    public OfferModel findOfferById(@PathVariable long id){
        return offerService.findById(id);
    }
}
