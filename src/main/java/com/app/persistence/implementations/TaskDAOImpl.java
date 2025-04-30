package com.app.persistence.implementations;

import com.app.models.Task;
import com.app.persistence.ITaskDAO;
import com.app.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TaskDAOImpl implements ITaskDAO {


    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List<Task> findAll() {
        return (List<Task>) this.taskRepository.findAll();
    }

    @Override
    public Optional<Task> findById(Long id) {
        return this.taskRepository.findById(id);
    }

    @Override
    public void save(Task task) {
        this.taskRepository.save(task);

    }

    @Override
    public void deleteById(Long id) {
        this.taskRepository.deleteById(id);

    }
}
