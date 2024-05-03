package it.pi.registro.registro.dto;

import it.pi.registro.registro.entity.Subject;
import it.pi.registro.registro.entity.UserDetail;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserSubjectDTO {

    private String subjectName;
    private String subjectDesciption;
    private String teacherName;
    private double vote;
    private String notes;
    private LocalDateTime vote_date;

}