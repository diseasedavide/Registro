package it.pi.registro.registro.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "subject")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Subject {
    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String description;

    public Subject(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL)
    private Set<UserSubjects> userSubjects = new HashSet<>();


}

