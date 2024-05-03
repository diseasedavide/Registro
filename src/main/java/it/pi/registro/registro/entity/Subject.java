package it.pi.registro.registro.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "subject")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @OneToMany(mappedBy = "subject" , cascade = CascadeType.ALL)
    private Set<UserSubjects> userSubjects = new HashSet<>();

    public Subject(String name, String description) {
        this.name = name;
        this.description = description;
    }


    /*@OneToMany(mappedBy = "subject", cascade = CascadeType.ALL)
    //@JsonIgnoreProperties({"userSubjects","subject"}) // Ignore serialization of UserSubjects' subject reference
    prate Set<UserSubjects> userSubjects = new HashSet<>();*/
}
