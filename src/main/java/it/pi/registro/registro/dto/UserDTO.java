package it.pi.registro.registro.dto;

import it.pi.registro.registro.entity.Subject;
import it.pi.registro.registro.entity.UserDetail;
import it.pi.registro.registro.entity.UserSubjects;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private UserDetail userDetail;
    private Set<Subject> UserSubjects = new HashSet<>();

}