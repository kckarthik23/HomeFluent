package com.HomeFluent.Homeaccount.controllers;

import java.util.List;

import com.HomeFluent.Homeaccount.Services.UserService;
import com.HomeFluent.Homeaccount.dto.UserDto;
import com.HomeFluent.Homeaccount.entities.UserEntity;
import com.HomeFluent.Homeaccount.models.User;
import com.HomeFluent.Homeaccount.responseModels.UserRest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:8000")
@RequestMapping("/homeFluent")
public class HomeFluentController {

    @Autowired
    UserService userservice;
    @Autowired
    UserDto userDto;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping(value = "/users/createUser", consumes = "application/json", produces = "application/json")
    public ResponseEntity<UserEntity> createUser(@RequestBody User user) {

        BeanUtils.copyProperties(user, userDto);
        userDto.setPassword(passwordEncoder.encode(user.getPassword()));
        UserEntity response = userservice.createUser(userDto);
        ResponseEntity<UserEntity> entity;
        if (response != null)
            entity = new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        else
            entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return entity;

    }

    @GetMapping("/users/getAllUsers")
    public List<UserRest> getAllUsers() {
        return userservice.getAlUsers();
        // throw new RuntimeException("fuckeddddddd");
    }

    @GetMapping("/users/getUser/{name}")
    public UserDto getUser(@PathVariable String name) {
        return null;
    }

}
