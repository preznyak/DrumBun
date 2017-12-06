package hu.drumbun.service.need.impl;

import hu.drumbun.controller.need.model.NeedModel;
import hu.drumbun.entities.Need;
import hu.drumbun.entities.Offer;
import hu.drumbun.entities.User;
import hu.drumbun.repository.need.NeedRepository;
import hu.drumbun.repository.offer.OfferRepository;
import hu.drumbun.repository.path.PathRepository;
import hu.drumbun.repository.user.UserRepository;
import hu.drumbun.service.need.NeedService;
import hu.drumbun.service.need.converter.NeedModelConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NeedServiceImpl implements NeedService{

    private final NeedRepository needRepository;
    private final PathRepository pathRepository;
    private final OfferRepository offerRepository;
    private final NeedModelConverter needModelConverter;
    private final UserRepository userRepository;

    @Autowired
    public NeedServiceImpl(NeedRepository needRepository, PathRepository pathRepository, OfferRepository offerRepository, NeedModelConverter needModelConverter, UserRepository userRepository) {
        this.needRepository = needRepository;
        this.pathRepository = pathRepository;
        this.offerRepository = offerRepository;
        this.needModelConverter = needModelConverter;
        this.userRepository = userRepository;
    }

    @Override
    public List<NeedModel> findAll() {
        return needRepository.findAll().stream()
                .map(needModelConverter::fromNeedtoNeedModel)
                .collect(Collectors.toList());
    }

    @Override
    public NeedModel findById(long id) {
        return needModelConverter.fromNeedtoNeedModel(needRepository.findOne(id));
    }

    @Override
    public List<NeedModel> findByPath_Destination(String destination) {
        return needRepository.findByPath_Destination(destination).stream()
                .map(needModelConverter::fromNeedtoNeedModel)
                .collect(Collectors.toList());
    }

    @Override
    public List<NeedModel> findByPath_Start(String start) {
        return needRepository.findByPath_Start(start).stream()
                .map(needModelConverter::fromNeedtoNeedModel)
                .collect(Collectors.toList());
    }

    @Override
    public List<NeedModel> findByDateAfter(Date date) {
        return needRepository.findByDateAfter(date).stream()
                .map(needModelConverter::fromNeedtoNeedModel)
                .collect(Collectors.toList());
    }

    @Override
    public List<NeedModel> findByDateBefore(Date date) {
        return needRepository.findByDateBefore(date).stream()
                .map(needModelConverter::fromNeedtoNeedModel)
                .collect(Collectors.toList());
    }

    @Override
    public void updateNeed(NeedModel needModel) {
        Need updatedNeed = needModelConverter.fromNeedModelToNeed(needModel);
        updatedNeed.setUser(needRepository.findOne(updatedNeed.getId()).getUser());
        pathRepository.save(updatedNeed.getPath());
        needRepository.save(updatedNeed);
    }

    @Override
    public void createNeed(NeedModel needModel) {
        Need newNeed = needModelConverter.fromNeedModelToNeed(needModel);
        pathRepository.save(newNeed.getPath());
        needRepository.save(newNeed);
    }

    @Override
    public void receiveOffer(long needId, String username) {
        Need need = needRepository.findOne(needId);
        User user = userRepository.findByUsername(username);
        Offer newOffer = new Offer();
        newOffer.setUser(user);
        newOffer.setDate(need.getDate());
        newOffer.setPath(need.getPath());
        newOffer.setMaxSeats(3);
        List<Offer> offers = need.getOffers();
        offers.add(newOffer);
        need.setOffers(offers);
        needRepository.save(need);
    }

    @Override
    public List<NeedModel> findByAll(String start, String destination, String date) {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
        Date date1 = null;
        try {
            date1 = formatter.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return needRepository.findByPath_StartAndPath_DestinationAndDateAfter(start,destination,date1).stream()
                .map(needModelConverter::fromNeedtoNeedModel)
                .collect(Collectors.toList());
    }
}
