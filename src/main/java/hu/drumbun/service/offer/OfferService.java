package hu.drumbun.service.offer;

import hu.drumbun.controller.offer.model.OfferModel;

import java.util.Date;
import java.util.List;

public interface OfferService {
    List<OfferModel> findAll();
    OfferModel findById(long id);
    void deleteOfferById(long id);
    List<OfferModel> findByPath_Start(String start);
    List<OfferModel> findByPath_Destination(String destination);
    List<OfferModel> findByStartTimeBefore(Date date);
    List<OfferModel> findByStartTimeAfter(Date date);
    void updateOffer(OfferModel offerModel);
    void createOffer(OfferModel offerModel);
}
