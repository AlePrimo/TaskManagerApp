package com.app.controllers;

import com.app.controllers.dtos.UserEntityDTO;
import com.app.models.UserEntity;
import com.app.services.IUserEntityService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserEntityController {

    @Autowired
    private IUserEntityService userEntityService;


    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){

        List<UserEntityDTO> userEntityDTOList = this.userEntityService.findAll()
                .stream()
                .map(user ->UserEntityDTO.builder()
                        .id(user.getId())
                        .name(user.getName())
                        .lastName(user.getLastName())
                        .email(user.getEmail())
                        .taskList(user.getTaskList())
                        .build()).toList();

         return ResponseEntity.ok(userEntityDTOList);
    }


    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){

        Optional<UserEntity> user = this.userEntityService.findById(id);
  if(user.isPresent()){
      UserEntity userEntity = user.get();
      UserEntityDTO userEntityDTO = UserEntityDTO.builder()
              .id(userEntity.getId())
              .name(userEntity.getName())
              .lastName(userEntity.getLastName())
              .email(userEntity.getEmail())
              .taskList(userEntity.getTaskList())
              .build();
          return ResponseEntity.ok(userEntityDTO);
     }


        return ResponseEntity.notFound().build();
    }


    @PostMapping("/saveUser")
    public ResponseEntity<?> saveUser(@Valid @RequestBody UserEntityDTO userEntityDTO) throws URISyntaxException {

if(userEntityDTO.getName().isBlank()){
    return ResponseEntity.badRequest().build();
}


this.userEntityService.save(UserEntity
        .builder()
        .name(userEntityDTO.getName())
        .lastName(userEntityDTO.getLastName())
        .email(userEntityDTO.getEmail())
        .taskList(userEntityDTO.getTaskList())
        .build());
return  ResponseEntity.created(new URI("/api/users/saveUser")).build();

}


    @PutMapping("/updateUser/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @Valid @RequestBody UserEntityDTO userEntityDTO){

      Optional<UserEntity> userEntityOptional = this.userEntityService.findById(id);

if(userEntityOptional.isPresent()){
UserEntity userEntity = userEntityOptional.get();

userEntity.setName(userEntityDTO.getName());
userEntity.setLastName(userEntityDTO.getLastName());
userEntity.setEmail(userEntityDTO.getEmail());
userEntity.setTaskList(userEntityDTO.getTaskList());
this.userEntityService.save(userEntity);
    return ResponseEntity.ok("Registro Actualizado");

}

    return ResponseEntity.notFound().build();


}


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        Optional<UserEntity> userEntityOptional = this.userEntityService.findById(id);

        if(id != null && userEntityOptional.isPresent()){
            this.userEntityService.deleteById(id);
            return ResponseEntity.ok("Registro Eliminado");
        }

        return ResponseEntity.notFound().build();

    }





}
