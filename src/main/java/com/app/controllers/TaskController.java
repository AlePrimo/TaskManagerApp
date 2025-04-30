package com.app.controllers;

import com.app.controllers.dtos.TaskDTO;
import com.app.models.Task;
import com.app.services.ITaskService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private ITaskService iTaskService;


    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){
        List<TaskDTO> taskDTOList = this.iTaskService.findAll()
                .stream()
                .map(task -> TaskDTO.builder()
                        .id(task.getId())
                        .title(task.getTitle())
                        .description(task.getDescription())
                        .completed(task.isCompleted())
                        .user(task.getUser())
                        .build()).toList();
       return  ResponseEntity.ok(taskDTOList);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){

        Optional<Task> optionalTask = this.iTaskService.findById(id);
        if(optionalTask.isPresent()){
            Task task = optionalTask.get();
            TaskDTO taskDTO = TaskDTO.builder()
                    .id(task.getId())
                    .title(task.getTitle())
                    .description(task.getDescription())
                    .completed(task.isCompleted())
                    .user(task.getUser())
                    .build();
            return ResponseEntity.ok(taskDTO);
        }
        return ResponseEntity.notFound().build();


    }

    @PostMapping("/saveTask")
    public ResponseEntity<?> saveUser(@Valid @RequestBody TaskDTO taskDTO) throws URISyntaxException {
        if(taskDTO.getTitle().isBlank()){
            return ResponseEntity.badRequest().build();
        }
        this.iTaskService.save(Task.builder()
                .title(taskDTO.getTitle())
                .description(taskDTO.getDescription())
                .completed(taskDTO.isCompleted())
                .user(taskDTO.getUser())
                .build());
        return ResponseEntity.created(new URI("/api/tasks/saveTask")).build();

    }

    @PutMapping("/updateTask/{id}")
    public ResponseEntity<?> updateTask(@PathVariable Long id, @Valid @RequestBody TaskDTO taskDTO){
         Optional<Task> optionalTask = this.iTaskService.findById(id);

        if(optionalTask.isPresent()){

         Task task = optionalTask.get();
         task.setTitle(taskDTO.getTitle());
         task.setDescription(taskDTO.getDescription());
         task.setCompleted(taskDTO.isCompleted());
         this.iTaskService.save(task);

         return ResponseEntity.ok("Tarea Actualizada");
        }

        return ResponseEntity.notFound().build();
    }



    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable Long id){
        Optional<Task> optionalTask = this.iTaskService.findById(id);

        if(id != null && optionalTask.isPresent()){
            this.iTaskService.deleteById(id);
            return ResponseEntity.ok("Registro Eliminado");
        }

        return ResponseEntity.notFound().build();
    }




}
