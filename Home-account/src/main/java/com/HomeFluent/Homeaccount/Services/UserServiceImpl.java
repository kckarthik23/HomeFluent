package com.HomeFluent.Homeaccount.Services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.HomeFluent.Homeaccount.Security.UserDetails.DetailService;
import com.HomeFluent.Homeaccount.dto.UserDto;
import com.HomeFluent.Homeaccount.entities.UserEntity;
import com.HomeFluent.Homeaccount.repositories.UserRepo;
import com.HomeFluent.Homeaccount.responseModels.UserRest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.HomeFluent.Homeaccount.Security.UserDetail;
@Service
public class UserServiceImpl implements UserService, DetailService {

    @Autowired
    UserRepo userRepo;

    @Override
    public UserRest getUserByName(String name) {
        UserRest returnVal = null;
        UserEntity entity = userRepo.findByName(name);
        if (entity != null) {
            returnVal = new UserRest();
            BeanUtils.copyProperties(entity, returnVal);
        }

        // TODO Auto-generated method stub
        return returnVal;
    }

    @Override
    public UserRest getUserById(int id) {
        UserRest returnVal = null;
        UserEntity entity = userRepo.findById(id).get();
        if (entity != null) {
            returnVal = new UserRest();
            BeanUtils.copyProperties(entity, returnVal);
        }

        return returnVal;
    }

    @Override
    public List<UserRest> getAlUsers() {
        // TODO Auto-generated method stub
        List<UserRest> userRest = new ArrayList<>();
        BeanUtils.copyProperties((List<UserEntity>) userRepo.findAll(), userRest);
        return userRest;
    }

    @Override
    public UserRest createUser(UserDto user) {
        // TODO Auto-generated method stub
        user.setRegistrationDate(LocalDateTime.now());
        UserRest returnVal = new UserRest();
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);
        UserEntity entity = userRepo.save(userEntity);
        BeanUtils.copyProperties(entity, returnVal);
        return returnVal;

    }

    @Override
    public void deleteUser(String name) {
        // TODO Auto-generated method stub

    }

    @Override
    public UserRest updateUser(UserDto user) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        UserEntity entity = userRepo.findByName(username);
        if (entity == null)
            throw new UsernameNotFoundException(username);
        return new UserDetail(entity.getName(), entity.getPassword(), new ArrayList<>(),entity.getUserId());
    }

}
