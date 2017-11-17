package hu.drumbun.service.userprofile.converter;

import hu.drumbun.controller.userprofile.model.CreateUserProfileRequest;
import hu.drumbun.entities.UserProfile;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateUserProfileRequestConverter {

    private final ModelMapper modelMapper;

    @Autowired
    public CreateUserProfileRequestConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public UserProfile from(CreateUserProfileRequest createUserProfileRequest){
        return modelMapper.map(createUserProfileRequest,UserProfile.class);
    }
}
