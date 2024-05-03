package it.pi.registro.registro.service;

import it.pi.registro.registro.dto.request.AttendanceRegisterRequestDTO;
import it.pi.registro.registro.dto.request.SubjectCreateRequestDTO;
import it.pi.registro.registro.dto.response.AttendanceRegisterResponseDTO;
import it.pi.registro.registro.entity.Attendance;
import it.pi.registro.registro.entity.Subject;

import java.util.List;

public interface AttendanceService {
    AttendanceRegisterResponseDTO registerAttendance (AttendanceRegisterRequestDTO attendanceRegisterRequestDTO);
}
