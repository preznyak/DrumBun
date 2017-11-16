package hu.drumbun.service.offer;

import hu.drumbun.controller.offer.model.OfferModel;

import java.util.List;

public interface OfferService {
    List<OfferModel> findAll();
    OfferModel findById(long id);
    void deleteOfferById(long id);
}
