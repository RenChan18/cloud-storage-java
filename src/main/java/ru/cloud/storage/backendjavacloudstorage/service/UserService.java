package ru.cloud.storage.backendjavacloudstorage.service;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import ru.cloud.storage.backendjavacloudstorage.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Connection;
import java.sql.DriverManager;

@Service


public class UserService {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Autowired
    private JdbcTemplate jdbcTemplate;

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

    public Boolean deleteUser(Long userId) {
            MapSqlParameterSource sqlSource = new MapSqlParameterSource()
                    .addValue("userId", userId);

            try {
                this.namedParameterJdbcTemplate.update(
                        "DELETE FROM users WHERE id = :userId",
                        sqlSource);

                return true;
            } catch (Exception exception) {
                return false;
            }
    }

    public User getUser(Long userId) {
        String sql = "SELECT * FROM users WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{userId}, new BeanPropertyRowMapper<>(User.class));
    }
}
