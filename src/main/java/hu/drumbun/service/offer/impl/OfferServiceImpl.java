package hu.drumbun.service.offer.impl;

import hu.drumbun.controller.need.model.NeedModel;
import hu.drumbun.controller.offer.model.OfferModel;
import hu.drumbun.entities.Need;
import hu.drumbun.entities.Offer;
import hu.drumbun.entities.User;
import hu.drumbun.repository.need.NeedRepository;
import hu.drumbun.repository.offer.OfferRepository;
import hu.drumbun.repository.path.PathRepository;
import hu.drumbun.repository.user.UserRepository;
import hu.drumbun.service.need.converter.NeedModelConverter;
import hu.drumbun.service.offer.OfferService;
import hu.drumbun.service.offer.converter.OfferModelConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;
    private final PathRepository pathRepository;
    private final OfferModelConverter offerModelConverter;
    private final UserRepository userRepository;
    private final NeedModelConverter needModelConverter;
    private final NeedRepository needRepository;

    @Autowired
    public OfferServiceImpl(OfferRepository offerRepository, PathRepository pathRepository, OfferModelConverter offerModelConverter, UserRepository userRepository, NeedModelConverter needModelConverter, NeedRepository needRepository) {
        this.offerRepository = offerRepository;
        this.pathRepository = pathRepository;
        this.offerModelConverter = offerModelConverter;
        this.userRepository = userRepository;
        this.needModelConverter = needModelConverter;
        this.needRepository = needRepository;
    }

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
    public List<OfferModel> findByDateBefore(Date date) {
        return offerRepository.findByDateBefore(date).stream()
                .map(offerModelConverter::fromOfferToOfferModel)
                .collect(Collectors.toList());
    }

    @Override
    public List<OfferModel> findByDateAfter(Date date) {
        return offerRepository.findByDateAfter(date).stream()
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
    public void createOffer(OfferModel offerModel, String username) {
        Offer newOffer = offerModelConverter.fromOfferModelToOffer(offerModel);
        newOffer.setUser(userRepository.findByUsername(username));
        pathRepository.save(newOffer.getPath());
        offerRepository.save(newOffer);
    }


    @Override
    public void joinToOffer(long offerId, String username) {
        Offer offer = offerRepository.findOne(offerId);
        List<User> passengers = offer.getPassengers();
        passengers.add(userRepository.findByUsername(username));
        offer.setPassengers(passengers);
        offer.setOccupiedSeats(offer.getOccupiedSeats()+1);
        offerRepository.save(offer);
    }

    @Override
    public List<OfferModel> findByAll(String start, String destination, String date) {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
        Date date1 = null;
        try {
            date1 = formatter.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return offerRepository.findByPath_StartAndPath_DestinationAndDateAfter(start, destination, date1).stream()
                .map(offerModelConverter::fromOfferToOfferModel)
                .collect(Collectors.toList());
    }
}
