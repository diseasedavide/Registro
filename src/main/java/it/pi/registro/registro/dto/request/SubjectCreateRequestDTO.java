package it.pi.registro.registro.dto.request;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubjectCreateRequestDTO {


    @Size(max=20,min=3)
    private String subjectName;

    @Size(max=20,min=3)
    private String subjectDescription;


    @Override
    public String toString() {
        return "SubjectCreateDTO{" +
                "subjectName='" + subjectName + '\'' +
                ", subjecDescription='" + subjectDescription + '\'' +
                '}';
    }
}
