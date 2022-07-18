package com.HomeFluent.Homeaccount.Security.UserDetails;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.HomeFluent.Homeaccount.dto.UserDto;
import com.HomeFluent.Homeaccount.responseModels.UserRest;

public interface DetailService extends UserDetailsService {
    public UserRest createUser(UserDto user);
}
