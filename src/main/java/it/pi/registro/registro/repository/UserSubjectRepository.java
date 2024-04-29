package it.pi.registro.registro.repository;

import it.pi.registro.registro.entity.UserSubjects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSubjectRepository extends JpaRepository<UserSubjects, Long> {

}
