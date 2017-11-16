package hu.drumbun.service.user.converter;

import hu.drumbun.controller.user.model.UserResponse;
import hu.drumbun.entities.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserResponseConverter {

    private final ModelMapper modelMapper;

    @Autowired
    public UserResponseConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public UserResponse from(User user){
        return modelMapper.map(user,UserResponse.class);
    }
}
