package hu.drumbun.service.offer.converter;

import hu.drumbun.controller.offer.model.OfferModel;
import hu.drumbun.entities.Offer;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OfferModelConverter {

    private final ModelMapper modelMapper;

    @Autowired
    public OfferModelConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Offer fromOfferModelToOffer(OfferModel offerModel){
        return modelMapper.map(offerModel,Offer.class);
    }

    public OfferModel fromOfferToOfferModel(Offer offer){
        return modelMapper.map(offer, OfferModel.class);
    }
}
