package it.pi.registro.registro.service.impl;

import it.pi.registro.registro.dto.request.AttendanceRegisterRequestDTO;
import it.pi.registro.registro.dto.response.AttendanceRegisterResponseDTO;
import it.pi.registro.registro.entity.Attendance;
import it.pi.registro.registro.entity.User;
import it.pi.registro.registro.repository.AttendanceRepository;
import it.pi.registro.registro.repository.UserRepository;
import it.pi.registro.registro.service.AttendanceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    private static final Logger logger = LoggerFactory.getLogger(AttendanceService.class);

    @Autowired
     private AttendanceRepository attendanceRepository;
    @Autowired
     private UserRepository userRepository;

     AttendanceRegisterResponseDTO attendanceRegisterResponseDTO;

    @Override
    public AttendanceRegisterResponseDTO registerAttendance(AttendanceRegisterRequestDTO attRegRequestDTO) {

        logger.info("registerAttendance()....");
        User student = userRepository.findById(attRegRequestDTO.getStudentId()).get();
        User teacher = userRepository.findById(attRegRequestDTO.getTeacherId()).get();
        attendanceRepository.save(new Attendance(
                attRegRequestDTO.getReferDate(),
                LocalDateTime.now(),
                attRegRequestDTO.getEntranceDate(),
                attRegRequestDTO.getExitDate(),
                student,
                teacher
        ));

        return new AttendanceRegisterResponseDTO(
                student.getFirstName() + " " + student.getLastName(),
                teacher.getFirstName() + " " + teacher.getLastName()
        );
    }


}