package ru.cloud.storage.backendjavacloudstorage.model;


import jakarta.persistence.*;
import lombok.*;

import java.sql.Connection;
import java.sql.DriverManager;


@Entity
@Setter
@Getter
@Table(name = "users")
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @Basic
    @Column(name = "firstname")
    private String firstname;
    @Basic
    @Column(name = "lastname")
    private String lastname;
    @Basic
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @Basic
    @Column(name = "hashpassword")
    private String hashpassword;

    //add psql/jdbc


}
