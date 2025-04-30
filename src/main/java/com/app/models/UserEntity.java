package com.app.models;

import jakarta.persistence.*;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @NotBlank
    @Size(min = 3, max = 50)
    String name;
    @Size(min = 3, max = 50)
    @Column(name = "last_name")
    @NotBlank
    String lastName;
    @Email
    @NotBlank
    String email;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    List<Task> taskList = new ArrayList<>();


}
