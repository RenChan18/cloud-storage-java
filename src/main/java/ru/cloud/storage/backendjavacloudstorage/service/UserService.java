package ru.cloud.storage.backendjavacloudstorage.service;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import ru.cloud.storage.backendjavacloudstorage.dto.request.UserRequest;
import ru.cloud.storage.backendjavacloudstorage.dto.response.UserResponse;
import ru.cloud.storage.backendjavacloudstorage.facade.UserFacade;
import ru.cloud.storage.backendjavacloudstorage.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import ru.cloud.storage.backendjavacloudstorage.repository.UserRepository;

import java.sql.Connection;
import java.sql.DriverManager;

@Service
@RequiredArgsConstructor

public abstract class UserService implements BaseService<UserRequest, UserResponse> {

    private final UserFacade userFacade;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final UserRepository userRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Integer createUser(UserRequest userRequest) {
        try {

            return this.namedParameterJdbcTemplate.update("insert into users (firstname, lastname, email, hashpassword)  values (:firstname, :lastname, :email, :hashpassword);", userFacade.toCreateUser(userRequest));
        } catch (Exception e) {
            return 0;
        }
    }


    public Integer updateUser(UserRequest userRequest) {
        try {
            return this.namedParameterJdbcTemplate.update("UPDATE users SET firstname = :firstname, lastname = :lastname, email = :email, hashpassword = :hashpassword WHERE id = :userId"
                    , userFacade.toUpdateUser(userRequest));
        } catch (Exception e) {
            return 0;
        }
    }


    public Integer deleteUser(UserRequest userRequest) {
        try {
            return this.namedParameterJdbcTemplate.update("DELETE FROM users WHERE id = :userId"
                    , userFacade.toDeleteUser(userRequest));
        } catch (Exception e) {
            return 0;
        }
    }


    public UserResponse findUserByFirstName(String username) {
        return userFacade.toResponse(userRepository.findUserByFirstName(username).orElseThrow(() -> new RuntimeException("Username not found with username " + username)));
    }
}