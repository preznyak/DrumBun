package hu.drumbun.service.user.converter;

import hu.drumbun.controller.user.model.LoginUser;
import hu.drumbun.entities.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginUserConverter {

    private final ModelMapper modelMapper;

    @Autowired
    public LoginUserConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public User fromLoginUserToUser(LoginUser loginUser){
        return modelMapper.map(loginUser,User.class);
    }

    public LoginUser fromUserToLoginUser(User user){return modelMapper.map(user,LoginUser.class);}
}
