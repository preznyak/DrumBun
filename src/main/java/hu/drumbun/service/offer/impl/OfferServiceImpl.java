package hu.drumbun.service.offer.impl;

import hu.drumbun.controller.offer.model.OfferModel;
import hu.drumbun.repository.offer.OfferRepository;
import hu.drumbun.service.offer.OfferService;
import hu.drumbun.service.offer.converter.OfferModelConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;
    private final OfferModelConverter offerModelConverter;

    @Autowired
    public OfferServiceImpl(OfferRepository offerRepository, OfferModelConverter offerModelConverter) {
        this.offerRepository = offerRepository;
        this.offerModelConverter = offerModelConverter;
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
}
