package com.HomeFluent.Homeaccount.Security.UserDetails;


import org.springframework.security.core.userdetails.UserDetailsService;

import com.HomeFluent.Homeaccount.dto.UserDto;
import com.HomeFluent.Homeaccount.entities.UserEntity;

public interface DetailService extends UserDetailsService{
    public UserEntity createUser(UserDto user);  
}
