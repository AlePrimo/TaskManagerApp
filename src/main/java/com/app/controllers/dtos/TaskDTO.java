package com.app.controllers.dtos;


import com.app.models.UserEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder

public class TaskDTO {

    Long id;
    String title;
    String description;
    boolean completed;
    UserEntity user;

}
