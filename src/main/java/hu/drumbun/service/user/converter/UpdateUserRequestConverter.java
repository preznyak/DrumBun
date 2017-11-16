package hu.drumbun.service.user.converter;

import hu.drumbun.controller.user.model.UpdateUserRequest;
import hu.drumbun.entities.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateUserRequestConverter {

    private final ModelMapper modelMapper;

    @Autowired
    public UpdateUserRequestConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public User from(UpdateUserRequest updateUserRequest){
        return modelMapper.map(updateUserRequest,User.class);
    }
}
