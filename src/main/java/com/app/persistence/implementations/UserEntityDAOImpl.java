package com.app.persistence.implementations;

import com.app.models.UserEntity;
import com.app.persistence.IUserEntityDAO;
import com.app.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserEntityDAOImpl implements IUserEntityDAO {


    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserEntity> findAll() {
        return (List<UserEntity>) this.userRepository.findAll();
    }

    @Override
    public Optional<UserEntity> findById(Long id) {
        return this.userRepository.findById(id);
    }

    @Override
    public void save(UserEntity user) {
        this.userRepository.save(user);

    }

    @Override
    public void deleteById(Long id) {
       this.userRepository.deleteById(id);
    }
}
