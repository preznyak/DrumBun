package hu.drumbun.service.need.converter;

import hu.drumbun.controller.need.model.OffersNeedModel;
import hu.drumbun.entities.Need;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OffersNeedModelConverter {

    private final ModelMapper modelMapper;

    @Autowired
    public OffersNeedModelConverter (ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public OffersNeedModel fromNeedToOffersNeedModel(Need need){return modelMapper.map(need, OffersNeedModel.class);}

    public Need fromOffersNeedModelToNeed(OffersNeedModel offersNeedModel){return modelMapper.map(offersNeedModel, Need.class);}

}
