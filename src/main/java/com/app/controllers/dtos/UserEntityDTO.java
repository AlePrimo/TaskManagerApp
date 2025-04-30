package com.app.controllers.dtos;


import com.app.models.Task;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
    @NotBlank(message = "El usuario debe tener un nombre para ser ingresado")
    @Size(min = 3, max = 50, message = "El nombre debe tener entre 3 y 50 caracteres como maximo")
    String name;
    @NotBlank(message = "El usuario debe tener un apellido para ser ingresado")
    @Size(min = 3, max = 50, message = "El apellido debe tener entre 3 y 50 caracteres como maximo")
    String lastName;
    @NotBlank(message = "El usuario debe tener un email para ser ingresado")
    String email;
    List<Task> taskList = new ArrayList<>();

}
