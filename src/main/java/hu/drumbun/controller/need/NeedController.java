package hu.drumbun.controller.need;

import hu.drumbun.controller.need.model.NeedModel;
import hu.drumbun.service.need.NeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/needs")
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
}
