package com.HomeFluent.Homeaccount.Services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.HomeFluent.Homeaccount.dto.UserDto;
import com.HomeFluent.Homeaccount.entities.UserEntity;
import com.HomeFluent.Homeaccount.repositories.UserRepo;
import com.HomeFluent.Homeaccount.responseModels.UserRest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;
    @Autowired
    UserRest userRest;

    @Override
    public UserDto getUserByName(String name) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public UserDto getUserById(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<UserRest> getAlUsers() {
        // TODO Auto-generated method stub
        List<UserRest> userRest = new ArrayList<>();
        BeanUtils.copyProperties((List<UserEntity>) userRepo.findAll(), userRest);
        return userRest;
    }

    @Override
    public UserEntity createUser(UserDto user) {
        // TODO Auto-generated method stub
        user.setLocalDateAndTime(LocalDateTime.now());
        UserEntity userEntity=new UserEntity();
        BeanUtils.copyProperties(user, userEntity);
        UserEntity returnVal = userRepo.save(userEntity);
        return returnVal;

    }

    @Override
    public void deleteUser(String name) {
        // TODO Auto-generated method stub

    }

    @Override
    public UserDto updateUser(UserDto user) {
        // TODO Auto-generated method stub
        return null;
    }

}
