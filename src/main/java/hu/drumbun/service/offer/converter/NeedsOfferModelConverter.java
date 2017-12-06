package hu.drumbun.service.offer.converter;

import hu.drumbun.controller.offer.model.NeedsOfferModel;
import hu.drumbun.entities.Offer;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class NeedsOfferModelConverter {

    private final ModelMapper modelMapper;

    @Autowired
    public NeedsOfferModelConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Offer fromNeedsOfferModelToOffer(NeedsOfferModel needsOfferModel){
        return modelMapper.map(needsOfferModel,Offer.class);
    }

    public NeedsOfferModel fromOfferToNeedsOfferModel(Offer offer){
        return modelMapper.map(offer, NeedsOfferModel.class);
    }
}
