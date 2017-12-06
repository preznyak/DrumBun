package hu.drumbun.service.need;

import hu.drumbun.controller.need.model.NeedModel;
import hu.drumbun.entities.Need;

import java.util.Date;
import java.util.List;

public interface NeedService {
    List<NeedModel> findAll();
    NeedModel findById(long id);
    List<NeedModel> findByPath_Destination(String destination);
    List<NeedModel> findByPath_Start(String start);
    List<NeedModel> findByDateAfter(Date date);
    List<NeedModel> findByDateBefore(Date date);
    void updateNeed(NeedModel needModel);
    void createNeed(NeedModel needModel, String username);


    void receiveOffer(long needId, String username);
    List<NeedModel> findByAll(String start,String destination,String date);
}
