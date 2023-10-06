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

    public User(Long userId, String firstname, String lastname, String email, String hashPassword){
        this.userId = userId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.hashPassword = hashPassword;
    }

    public static User createUser(Long userId, String firstname, String lastname, String email, String hashPassword) {
        //
        return new User(userId,firstname,lastname, email,  hashPassword);
    }


    public void deleteUser(){
        this.userId = null;
        this.firstname = null;
        this.lastname = null;
        this.email = null;
        this.hashPassword = null;
    }



}
