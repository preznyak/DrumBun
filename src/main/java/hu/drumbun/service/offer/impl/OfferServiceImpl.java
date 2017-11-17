package hu.drumbun.service.offer.impl;

import hu.drumbun.controller.offer.model.OfferModel;
import hu.drumbun.entities.Offer;
import hu.drumbun.repository.offer.OfferRepository;
import hu.drumbun.repository.path.PathRepository;
import hu.drumbun.service.offer.OfferService;
import hu.drumbun.service.offer.converter.OfferModelConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;
    private final PathRepository pathRepository;
    private final OfferModelConverter offerModelConverter;

    @Autowired
    public OfferServiceImpl(OfferRepository offerRepository, PathRepository pathRepository, OfferModelConverter offerModelConverter) {
        this.offerRepository = offerRepository;
        this.pathRepository = pathRepository;
        this.offerModelConverter = offerModelConverter;
    }

    @Autowired


    @Override
    public List<OfferModel> findAll() {
        return offerRepository.findAll().stream()
                .map(offerModelConverter::fromOfferToOfferModel)
                .collect(Collectors.toList());
    }

    @Override
    public OfferModel findById(long id) {
        return offerModelConverter.fromOfferToOfferModel(offerRepository.findOne(id));
    }

    @Override
    public void deleteOfferById(long id) {
        offerRepository.delete(id);
    }

    @Override
    public List<OfferModel> findByPath_Start(String start) {
        return offerRepository.findByPath_Start(start).stream()
                .map(offerModelConverter::fromOfferToOfferModel)
                .collect(Collectors.toList());
    }

    @Override
    public List<OfferModel> findByPath_Destination(String destination) {
        return offerRepository.findByPath_Destination(destination).stream()
                .map(offerModelConverter::fromOfferToOfferModel)
                .collect(Collectors.toList());
    }

    @Override
    public List<OfferModel> findByStartTimeBefore(Date date) {
        return offerRepository.findByStartTimeBefore(date).stream()
                .map(offerModelConverter::fromOfferToOfferModel)
                .collect(Collectors.toList());
    }

    @Override
    public List<OfferModel> findByStartTimeAfter(Date date) {
        return offerRepository.findByStartTimeAfter(date).stream()
                .map(offerModelConverter::fromOfferToOfferModel)
                .collect(Collectors.toList());
    }

    @Override
    public void updateOffer(OfferModel offerModel) {
        Offer updatedOffer = offerModelConverter.fromOfferModelToOffer(offerModel);
        updatedOffer.setUser(offerRepository.findOne(updatedOffer.getId()).getUser());
        pathRepository.save(updatedOffer.getPath());
        offerRepository.save(updatedOffer);
    }

    @Override
    public void createOffer(OfferModel offerModel) {
        /**
         * future task
         */
        Offer newOffer = offerModelConverter.fromOfferModelToOffer(offerModel);
        pathRepository.save(newOffer.getPath());
        offerRepository.save(newOffer);
    }
}
