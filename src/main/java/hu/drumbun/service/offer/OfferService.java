package hu.drumbun.service.offer;

import hu.drumbun.controller.need.model.NeedModel;
import hu.drumbun.controller.offer.model.OfferModel;
import hu.drumbun.entities.Offer;

import java.util.Date;
import java.util.List;

public interface OfferService {
    List<OfferModel> findAll();
    OfferModel findById(long id);
    void deleteOfferById(long id);
    List<OfferModel> findByPath_Start(String start);
    List<OfferModel> findByPath_Destination(String destination);
    List<OfferModel> findByDateBefore(Date date);
    List<OfferModel> findByDateAfter(Date date);
    void updateOffer(OfferModel offerModel);
    void createOffer(OfferModel offerModel, String username);
    void addNeed(long offerId,NeedModel needModel);

    void joinToOffer(long offerId, String username);
}
