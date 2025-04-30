package com.app.persistence;

import com.app.models.UserEntity;

import java.util.List;
import java.util.Optional;

public interface IUserEntityDAO {

    List<UserEntity> findAll();
    Optional<UserEntity> findById(Long id);
    void save(UserEntity user);
    void deleteById(Long id);


}
