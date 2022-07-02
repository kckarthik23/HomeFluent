package com.HomeFluent.Homeaccount.Services;

import java.util.List;

import com.HomeFluent.Homeaccount.dto.UserDto;
import com.HomeFluent.Homeaccount.entities.UserEntity;
import com.HomeFluent.Homeaccount.responseModels.UserRest;

import org.springframework.stereotype.Service;

@Service
public interface UserService {
    public UserDto getUserByName(String name);

    public UserDto getUserById(int id);

    public List<UserRest> getAlUsers();

    public UserEntity createUser(UserDto user);

    public void deleteUser(String name);

    public UserDto updateUser(UserDto user);

}
