package it.pi.registro.registro.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users_detail")
@Getter
@Setter
public class UserDetail {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String address;
    @Column
    private String city;

}
