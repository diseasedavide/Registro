package it.pi.registro.registro.dto.response;

import it.pi.registro.registro.dto.UserSubjectDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDataResponseDTO {
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private int daysToBirthday;
    private int age;
    private String email;
    private String address;
    private String city;
    private String role;
    private List<UserSubjectDTO> votes;
    private String currentSchoolClass;

}
