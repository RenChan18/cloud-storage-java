package ru.cloud.storage.backendjavacloudstorage.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;

//@Builder ?
@Entity
@Table(name = "user")
public class User {
    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long userId;
    private String firstname;
    private String lastname;
    private String email;
    private String hashPassword;
}
