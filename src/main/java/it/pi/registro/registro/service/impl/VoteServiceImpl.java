package it.pi.registro.registro.service.impl;

import it.pi.registro.registro.dto.request.VoteAssignRequestDTO;
import it.pi.registro.registro.dto.response.VoteAssignResponseDTO;
import it.pi.registro.registro.entity.Subject;
import it.pi.registro.registro.entity.User;
import it.pi.registro.registro.entity.UserSubjects;
import it.pi.registro.registro.enums.UserTypeEnum;
import it.pi.registro.registro.repository.SubjectRepository;
import it.pi.registro.registro.repository.UserRepository;
import it.pi.registro.registro.repository.UserSubjectRepository;
import it.pi.registro.registro.service.VoteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
@AllArgsConstructor
public class VoteServiceImpl implements VoteService {

    private UserRepository userRepository;
    private SubjectRepository subjectRepository;
    private UserSubjectRepository userSubjectRepository;

    @Override
    public VoteAssignResponseDTO assignVote(VoteAssignRequestDTO voteAssignRequestDTO) throws Exception {
        User student = userRepository.findMailAndType(
                voteAssignRequestDTO.getStudentEmail(),
                String.valueOf(UserTypeEnum.STUDENT));
        System.out.println("the student is : " );
        System.out.println(student.getUserType());


        User teacher = userRepository.findMailAndType(
                voteAssignRequestDTO.getTeacherEmail(),
                String.valueOf(UserTypeEnum.TEACHER));
        System.out.println("the teacher is : " );
        System.out.println(teacher.getUserType());

        Subject subject = subjectRepository.findByName(voteAssignRequestDTO.getSubjectName());

        if(student == null || teacher == null || subject == null){
            throw new Exception();
        }

        UserSubjects userSubjects = new UserSubjects();
        userSubjects.setUser(student);
        userSubjects.setTeacher(teacher);
        userSubjects.setSubject(subject);
        userSubjects.setVote(voteAssignRequestDTO.getVote());
        userSubjects.setNotes(voteAssignRequestDTO.getNotes());

        userSubjectRepository.save(userSubjects);

        return new VoteAssignResponseDTO(String.valueOf(userSubjects.getVote()), userSubjects.getVote_date());
    }
}
