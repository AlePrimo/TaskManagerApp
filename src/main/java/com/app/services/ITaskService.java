package com.app.services;

import com.app.models.Task;

import java.util.List;
import java.util.Optional;

public interface ITaskService {
    List<Task> findAll();
    Optional<Task> findById(Long id);
    void save(Task task);
    void deleteById(Long id);

}
