package hu.drumbun.service.user.converter;

import hu.drumbun.controller.user.model.UsernameModel;
import hu.drumbun.entities.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class UsernameModelConverter {

    private final ModelMapper modelMapper;

    @Autowired
    public UsernameModelConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public UsernameModel from(User user){
        return modelMapper.map(user,UsernameModel.class);
    }
}
