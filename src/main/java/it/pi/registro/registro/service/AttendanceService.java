package it.pi.registro.registro.service;

import it.pi.registro.registro.dto.request.AttendanceRegisterRequestDTO;
import it.pi.registro.registro.dto.response.AttendanceRegisterResponseDTO;
import org.springframework.stereotype.Service;

@Service
public interface AttendanceService {

    AttendanceRegisterResponseDTO registerAttendance(AttendanceRegisterRequestDTO attendanceRegisterRequestDTO);
}
