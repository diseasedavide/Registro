package it.pi.registro.registro.controller;

import it.pi.registro.registro.dto.request.AttendanceRegisterRequestDTO;
import it.pi.registro.registro.dto.response.AttendanceRegisterResponseDTO;
import it.pi.registro.registro.service.AttendanceService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("api/attendances")
public class AttendanceController {

    private static final Logger logger = LoggerFactory.getLogger(AttendanceController.class);

    private AttendanceService attendanceService;

    /**

     Register simple Attendance*/
    @PostMapping("/register")
    public ResponseEntity<AttendanceRegisterResponseDTO> registerAttendance(@Valid @RequestBody AttendanceRegisterRequestDTO attendanceRegisterRequestDTO){
        logger.info("RegisterAttendance...");
        return new ResponseEntity<>(attendanceService.registerAttendance(attendanceRegisterRequestDTO), HttpStatus.CREATED);

    }


}