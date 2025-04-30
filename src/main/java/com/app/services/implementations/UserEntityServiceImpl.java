package com.app.services.implementations;

import com.app.models.UserEntity;
import com.app.persistence.implementations.UserEntityDAOImpl;
import com.app.services.IUserEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserEntityServiceImpl implements IUserEntityService {

   @Autowired
   private UserEntityDAOImpl userEntityDAO;

    @Override
    public List<UserEntity> findAll() {
        return this.userEntityDAO.findAll();
    }

    @Override
    public Optional<UserEntity> findById(Long id) {
        return this.userEntityDAO.findById(id);
    }

    @Override
    public void save(UserEntity user) {
      this.userEntityDAO.save(user);
    }

    @Override
    public void deleteById(Long id) {
this.userEntityDAO.deleteById(id);
    }
}
