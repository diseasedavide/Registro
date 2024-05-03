package it.pi.registro.registro.service.impl;

import it.pi.registro.registro.dto.request.UserCreateRequestDTO;
import it.pi.registro.registro.dto.request.UserInfoRequestDTO;
import it.pi.registro.registro.dto.request.VoteAssignRequestDTO;
import it.pi.registro.registro.dto.response.UserInfoResponseDTO;
import it.pi.registro.registro.dto.response.VoteAssignResponseDTO;
import it.pi.registro.registro.entity.*;
import it.pi.registro.registro.enums.UserTypeEnum;
import it.pi.registro.registro.repository.SubjectRepository;
import it.pi.registro.registro.repository.UserRepository;
import it.pi.registro.registro.repository.UserSubjectRepository;
import it.pi.registro.registro.repository.UserTypeRepository;
import it.pi.registro.registro.service.UserService;
import it.pi.registro.registro.service.VoteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class VoteServiceImpl implements VoteService {

    private UserRepository userRepository;
    private SubjectRepository subjectRepository;
    private UserSubjectRepository userSubjectRepository;

    @Override
    public VoteAssignResponseDTO assignVote(VoteAssignRequestDTO voteAssignRequestDTO) throws Exception {

        User student = userRepository
                .findByMailAndType(
                    voteAssignRequestDTO.getStudentEmail(),
                    String.valueOf(UserTypeEnum.STUDENT)
        );

        User teacher = userRepository
                .findByMailAndType(
                    voteAssignRequestDTO.getTeacherEmail(),
                    String.valueOf(UserTypeEnum.TEACHER)
        );

        Subject subject = subjectRepository.findByName(voteAssignRequestDTO.getSubjectName());

        if(student==null || teacher==null || subject ==null)throw new Exception();

        UserSubjects userSubjects = new UserSubjects();

        userSubjects.setUser(student);
        userSubjects.setTeacher(teacher);
        userSubjects.setSubject(subject);
        userSubjects.setVote(voteAssignRequestDTO.getVote());
        userSubjects.setNotes(voteAssignRequestDTO.getNotes());
        userSubjectRepository.save(userSubjects);


        return new VoteAssignResponseDTO(
                String.valueOf(userSubjects.getVote()), userSubjects.getVote_date()
        );
    }
}
