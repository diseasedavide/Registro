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
public class AttendanceRegisterResponseDTO {
//    private LocalDateTime reference_date;
//    private LocalDateTime insertion_date;
//    private LocalDateTime entrance_date;
//    private LocalDateTime exit_date;
    private String student;
    private String teacher;


}
