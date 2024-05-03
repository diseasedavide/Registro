package it.pi.registro.registro.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

@Entity
@Table(name = "attendance")
@Getter
@Setter
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private LocalDateTime reference_date;

    @Column
    private LocalDateTime insertion_date;

    @Column
    private LocalDateTime entrance_date;

    @Column
    private LocalDateTime exit_date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties("attendances")
    private User student;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private User teacher;

    public Attendance(LocalDateTime reference_date, LocalDateTime insertion_date, LocalDateTime entrance_date, LocalDateTime exit_date, User student, User teacher) {
        this.reference_date = reference_date;
        this.insertion_date = insertion_date;
        this.entrance_date = entrance_date;
        this.exit_date = exit_date;
        this.student = student;
        this.teacher = teacher;
    }

    @PrePersist
    @PreUpdate
    public void prePersistUpdate() throws Exception {
        this.reference_date = this.reference_date == null ? LocalDateTime.now() : this.getReference_date();
        if (this.getEntrance_date().isAfter(this.getExit_date())) {
            throw new Exception("exception");
        }
    }

}
