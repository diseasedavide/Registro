package it.pi.registro.registro.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import it.pi.registro.registro.constant.Constants;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column
    private LocalDate dateOfBirth;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    private String activeClass;

    @OneToOne
    @JoinColumn(name = "user_detail_id", referencedColumnName = "id")
    //@JsonIgnoreProperties("user") // Ignore serialization of UserDetail's user reference
    private UserDetail userDetail;

    @ManyToOne
    @JoinColumn(name = "user_type_id", referencedColumnName = "id")
    //@JsonIgnoreProperties("user") // Ignore serialization of UserType's user reference
    private UserType userType;

    @OneToMany(mappedBy = "user")
    private Set<UserSubjects> userSubjects = new HashSet<>();

    @OneToMany(mappedBy = "user") // Cascade removal operations
    private Set<UserSchoolClass> userSchoolClasses = new HashSet<>();

    @OneToMany(mappedBy = "student") // Cascade removal operations
    private Set<Attendance> studentAttendances = new HashSet<>();

    public String getActiveClass() {
        String activeClass = Constants.NO_CLASS;
        for (UserSchoolClass userSchoolClass: this.getUserSchoolClasses()){
            if(userSchoolClass.getEndDate() == null){
                activeClass = userSchoolClass.getSchoolClass().getName();
                break;
            }
        }
        return activeClass;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
