package ru.cloud.storage.backendjavacloudstorage.service;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import ru.cloud.storage.backendjavacloudstorage.model.User;

import java.sql.Connection;
import java.sql.DriverManager;

@Service


public class UserService {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public UserService(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }
    public Boolean createUser(String firstname, String lastname, String email, String hashpassword) {
        MapSqlParameterSource in = new MapSqlParameterSource()
                .addValue("firstname", firstname)
                .addValue("lastname", lastname)
                .addValue("email", email)
                .addValue("hashpassword", hashpassword);

        try {
            this.namedParameterJdbcTemplate.update("insert into users (firstname, lastname, email, hashpassword)  " +
                                                    "values (:firstname, :lastname, :email, :hashpassword);",
                                                     in);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

   /* public Boolean updateUser(String currentEmailUser, User user) {
        MapSqlParameterSource sqlSource = new MapSqlParameterSource()
                .addValue("firstname", user.getFirstname())
                .addValue("lastname", user.getLastname())
                .addValue("email", user.getEmail())
                .addValue("hashpassword", user.getHashpassword())
                .addValue("currentEmailUser", currentEmailUser);
        try {
            this.namedParameterJdbcTemplate.update("update into users (firstname, lastname, email, hashpassword" +
                                                    "values (:firstname, :lastname, :email, :hashpassword)" +
                                                    "where email = :currentEmailUser",
                                                    sqlSource);

            return true;
        } catch (Exception exception) {
            return false;
        }
    }*/

    public Boolean updateUser(Long userId, String firstname, String lastname, String email, String hashpassword) {

        MapSqlParameterSource sqlSource = new MapSqlParameterSource()
                .addValue("userId", userId)
                .addValue("firstname", firstname)
                .addValue("lastname", lastname)
                .addValue("email",email)
                .addValue("hashpassword", hashpassword);
        try {
            this.namedParameterJdbcTemplate.update(
                    "UPDATE users SET firstname = :firstname, lastname = :lastname, email = :email, hashpassword = :hashpassword WHERE id = :userId",
                    sqlSource);

            return true;
        } catch (Exception exception) {
            return false;
        }
    }
}
