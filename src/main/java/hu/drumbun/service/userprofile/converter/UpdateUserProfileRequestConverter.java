package hu.drumbun.service.userprofile.converter;

import hu.drumbun.controller.userprofile.model.UpdateUserProfileRequest;
import hu.drumbun.entities.UserProfile;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateUserProfileRequestConverter {

    private final ModelMapper modelMapper;

    @Autowired
    public UpdateUserProfileRequestConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public UserProfile from(UpdateUserProfileRequest updateUserProfileRequest){
        return modelMapper.map(updateUserProfileRequest,UserProfile.class);
    }
}
