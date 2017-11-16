package hu.drumbun.service.need.converter;

import hu.drumbun.controller.need.NeedModel;
import hu.drumbun.entities.Need;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NeedModelConverter {

    private final ModelMapper modelMapper;

    @Autowired
    public NeedModelConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Need fromNeedModelToNeed(NeedModel needModel){
        return modelMapper.map(needModel,Need.class);
    }

    public NeedModel fromNeedtoNeedModel(Need need){
        return modelMapper.map(need, NeedModel.class);
    }

}
