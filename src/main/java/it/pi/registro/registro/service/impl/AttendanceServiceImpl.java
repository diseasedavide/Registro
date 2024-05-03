package it.pi.registro.registro.service.impl;

import it.pi.registro.registro.dto.request.AttendanceRegisterRequestDTO;
import it.pi.registro.registro.dto.request.UserCreateRequestDTO;
import it.pi.registro.registro.dto.request.UserInfoRequestDTO;
import it.pi.registro.registro.dto.response.AttendanceRegisterResponseDTO;
import it.pi.registro.registro.dto.response.UserInfoResponseDTO;
import it.pi.registro.registro.entity.Attendance;
import it.pi.registro.registro.entity.User;
import it.pi.registro.registro.entity.UserDetail;
import it.pi.registro.registro.entity.UserType;
import it.pi.registro.registro.enums.UserTypeEnum;
import it.pi.registro.registro.repository.AttendanceRepository;
import it.pi.registro.registro.repository.UserRepository;
import it.pi.registro.registro.repository.UserTypeRepository;
import it.pi.registro.registro.service.AttendanceService;
import it.pi.registro.registro.service.UserService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AttendanceServiceImpl implements AttendanceService {

    private static final Logger logger = LoggerFactory.getLogger(AttendanceService.class);

    private AttendanceRepository attendanceRepository;
    private UserRepository userRepository;

    @Override
    public AttendanceRegisterResponseDTO registerAttendance(AttendanceRegisterRequestDTO attRegRequestDTO) {
        logger.info("registerAttendance()....");

        User student = userRepository.findById(attRegRequestDTO.getStudentId()).get();

        logger.info("Saving Attendance for student {}....", student.getEmail());

        attendanceRepository.save(new Attendance(
                attRegRequestDTO.getReferDate(),
                LocalDateTime.now(),
                attRegRequestDTO.getEntranceDate(),
                attRegRequestDTO.getExitDate(),
                student,
                userRepository.findById(attRegRequestDTO.getTeacherId()).get()
        ));
        logger.info("User {} Saved!", student.getEmail());

        return new AttendanceRegisterResponseDTO(student.getFirstName() + " " + student.getLastName());
    }
}
