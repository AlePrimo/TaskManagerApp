package com.app.persistence;

import com.app.models.Task;

import java.util.List;
import java.util.Optional;

public interface ITaskDAO {

    List<Task> findAll();
    Optional<Task> findById(Long id);
    void save(Task task);
    void deleteById(Long id);

}
