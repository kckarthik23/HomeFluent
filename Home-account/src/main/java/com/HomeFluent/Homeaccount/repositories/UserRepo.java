package com.HomeFluent.Homeaccount.repositories;

import com.HomeFluent.Homeaccount.entities.UserEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<UserEntity, Integer> {
    public UserEntity findByName(String name);
}
