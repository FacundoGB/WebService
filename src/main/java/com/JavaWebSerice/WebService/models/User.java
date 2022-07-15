package com.JavaWebSerice.WebService.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "id")
    private Long id;

    @Getter @Setter @Column(name = "name")
    private String name;

    @Getter @Setter @Column(name = "surname")
    private String surname;

    @Getter @Setter @Column(name = "email")
    private String email;

    @Getter @Setter @Column(name = "phone")
    private String phone;

    @Getter @Setter @Column(name = "password")
    private String password;


}
