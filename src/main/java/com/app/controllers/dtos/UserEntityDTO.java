package com.app.controllers.dtos;


import com.app.models.Task;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class UserEntityDTO {

    Long id;
    String name;
    String lastName;
    String email;
    List<Task> taskList = new ArrayList<>();

}
