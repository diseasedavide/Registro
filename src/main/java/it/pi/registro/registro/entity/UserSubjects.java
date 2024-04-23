package it.pi.registro.registro.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_subjects")
@Getter
@Setter
public class UserSubjects {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private double vote;

    @Column
    private LocalDateTime vote_date;

    @Column
    private String notes;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties("userSubjects")
    private User user;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    @JsonIgnoreProperties("userSubjects")
    private Subject subject;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    @JsonIgnoreProperties("userSubjects")
    private User teacher;
}
