package it.pi.registro.registro.service.impl;

import it.pi.registro.registro.dto.request.SubjectCreateRequestDTO;
import it.pi.registro.registro.entity.Subject;
import it.pi.registro.registro.repository.SubjectRepository;
import it.pi.registro.registro.service.SubjectService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    SubjectRepository subjectRepository;


    @Override
    public Subject createSubject(SubjectCreateRequestDTO subjectCreateDTO) {
        return subjectRepository.save(new Subject(
                subjectCreateDTO.getSubjectName(),
                subjectCreateDTO.getSubjectDescription()
        ));
    }

    @Override
    public Subject getSubjectById(Long SubjectId) {
        return null;
    }

    @Override
    public List<Subject> getAllSubjects() {
        return List.of();
    }

    @Override
    public Subject updateSubject(Subject Subject) {
        return null;
    }

    @Override
    public void deleteSubject(Long SubjectId) {

    }
}
