package com.HomeFluent.Homeaccount.Services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

import com.HomeFluent.Homeaccount.Security.UserDetails.DetailService;
import com.HomeFluent.Homeaccount.dto.UserDto;
import com.HomeFluent.Homeaccount.entities.UserEntity;
import com.HomeFluent.Homeaccount.repositories.UserRepo;
import com.HomeFluent.Homeaccount.responseModels.UserRest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService,DetailService {

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
        userRepo.findById(id).get();
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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
       UserEntity entity= userRepo.findByName(username);
        if(entity==null) throw new UsernameNotFoundException(username);
        return new User(entity.getName(),entity.getPassword(),new ArrayList<>());
    }

}
