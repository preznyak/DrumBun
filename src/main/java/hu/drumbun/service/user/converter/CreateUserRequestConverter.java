package hu.drumbun.service.user.converter;

import hu.drumbun.controller.user.model.CreateUserRequest;
import hu.drumbun.entities.User;
import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateUserRequestConverter {

    private final ModelMapper modelMapper;

    @Autowired
    public CreateUserRequestConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public User from(CreateUserRequest createUserRequest){
        return modelMapper.map(createUserRequest,User.class);
    }
}
