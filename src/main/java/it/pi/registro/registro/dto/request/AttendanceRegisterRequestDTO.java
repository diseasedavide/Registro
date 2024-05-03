package it.pi.registro.registro.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AttendanceRegisterRequestDTO {

    private LocalDateTime entranceDate;
    private LocalDateTime exitDate;
    private LocalDateTime referDate;

    @NotNull
    private Long studentId;
    @NotNull
    private Long teacherId;

    private String notes;
}
