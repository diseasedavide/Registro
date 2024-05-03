package it.pi.registro.registro.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "attendance")
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private LocalDateTime referenceDate;

    @Column
    private LocalDateTime insertionDate;

    @Column
    private LocalDateTime entranceDate;

    @Column
    private LocalDateTime exitDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User student;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private User teacher;

    public Attendance(LocalDateTime referenceDate, LocalDateTime insertionDate, LocalDateTime entranceDate, LocalDateTime exitDate, User student, User teacher) {
        this.referenceDate = referenceDate;
        this.insertionDate = insertionDate;
        this.entranceDate = entranceDate;
        this.exitDate = exitDate;
        this.student = student;
        this.teacher = teacher;
    }

    @PrePersist
    @PreUpdate
    public void prePersist() throws Exception {
        this.referenceDate = this.referenceDate == null ? LocalDateTime.now() : this.getReferenceDate();
        if(this.getEntranceDate().isAfter(this.getExitDate())){
            throw new Exception("exceprt");
        }

    }

}
