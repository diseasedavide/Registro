package it.pi.registro.registro.service;

import it.pi.registro.registro.dto.request.SubjectCreateRequestDTO;
import it.pi.registro.registro.entity.Subject;

import java.util.List;

public interface SubjectService {

    Subject createSubject(SubjectCreateRequestDTO subjectCreateRequestDTO);

    Subject getSubjectById(Long subjectId);

    Subject getSubjectByEmail(String email);

    List<Subject> getAllSubjects();

    Subject updateSubject(Subject subject);

    void deleteSubject(Long subjectId);

}
