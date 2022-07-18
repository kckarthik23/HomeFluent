package com.HomeFluent.Homeaccount.Services;

import java.util.List;

import com.HomeFluent.Homeaccount.dto.UserDto;
import com.HomeFluent.Homeaccount.entities.UserEntity;
import com.HomeFluent.Homeaccount.responseModels.UserRest;

import org.springframework.stereotype.Service;

@Service
public interface UserService {
    public UserRest getUserByName(String name);

    public UserRest getUserById(int id);

    public List<UserRest> getAlUsers();

    public UserRest createUser(UserDto user);

    public void deleteUser(String name);

    public UserRest updateUser(UserDto user);

}
