package it.pi.registro.registro.service;

import it.pi.registro.registro.dto.request.SubjectCreateRequestDTO;
import it.pi.registro.registro.entity.Subject;

import java.util.List;

public interface SubjectService {

    Subject createSubject(SubjectCreateRequestDTO subjectCreateDTO);

    Subject getSubjectById(Long SubjectId);

    List<Subject> getAllSubjects();

    Subject updateSubject(Subject Subject);

    void deleteSubject(Long SubjectId);
}
