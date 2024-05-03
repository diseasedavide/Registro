package it.pi.registro.registro.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserVotesResponse {
    private double vote;
    private LocalDateTime date;
    private String teacherName;
    private String teacherSurname;
    private String subjName;
    private String subjDescr;
}
