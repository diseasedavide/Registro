package it.pi.registro.registro.repository;

import it.pi.registro.registro.entity.Subject;
import it.pi.registro.registro.entity.User;
import it.pi.registro.registro.entity.UserSubjects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface UserSubjectRepository extends JpaRepository<UserSubjects, Long> {

    @Query("SELECT us from UserSubjects us WHERE us.vote_date BETWEEN :start AND :end AND us.user.id = :userId")
    List<UserSubjects> findVotesByRange(
            @Param("start") LocalDateTime start,
            @Param("end") LocalDateTime end,
            @Param("userId") Long userId);

}
