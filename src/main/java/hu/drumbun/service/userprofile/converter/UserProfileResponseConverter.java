package hu.drumbun.service.userprofile.converter;

import hu.drumbun.controller.userprofile.model.UserProfileResponse;
import hu.drumbun.entities.UserProfile;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserProfileResponseConverter {

    private final ModelMapper modelMapper;

    @Autowired
    public UserProfileResponseConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public UserProfileResponse from(UserProfile userProfile){
        return modelMapper.map(userProfile,UserProfileResponse.class);
    }
}
