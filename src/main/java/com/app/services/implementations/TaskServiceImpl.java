package com.app.services.implementations;

import com.app.models.Task;
import com.app.persistence.implementations.TaskDAOImpl;
import com.app.services.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements ITaskService {

    @Autowired
    private TaskDAOImpl taskDAO;
    @Override
    public List<Task> findAll() {
        return this.taskDAO.findAll();
    }

    @Override
    public Optional<Task> findById(Long id) {
        return this.taskDAO.findById(id);
    }

    @Override
    public void save(Task task) {
this.taskDAO.save(task);
    }

    @Override
    public void deleteById(Long id) {
this.taskDAO.deleteById(id);
    }
}
