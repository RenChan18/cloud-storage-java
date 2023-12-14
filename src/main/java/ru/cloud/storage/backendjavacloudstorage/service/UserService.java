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

public class UserService implements BaseService<UserRequest, UserResponse> {

    private final UserFacade userFacade;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final UserRepository userRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public UserResponse getReferenceById(String id) {
        return userFacade.toResponse(userRepository.findUserById(Long.parseLong(id))
                .orElseThrow(() -> new RuntimeException("Username not found with id " + id)));
    }

    @Override
    public UserResponse create(UserRequest userRequest) {
        try {
            if(0 != this.namedParameterJdbcTemplate.update("insert into users (firstname, lastname, email, hashpassword)  values (:firstname, :lastname, :email, :hashpassword);"
                    , userFacade.toCreateUser(userRequest)))
                return userFacade.toResponse(userFacade.toUser(userRequest));
            else
                return null;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public UserResponse update(UserRequest userRequest) {
        try {
            if (0 != this.namedParameterJdbcTemplate.update("UPDATE users SET firstname = :firstname, lastname = :lastname, email = :email, hashpassword = :hashpassword WHERE id = :userId"
                    , userFacade.toUpdateUser(userRequest)))
                return userFacade.toResponse(userFacade.toUser(userRequest));
            else
                return null;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Boolean delete(UserRequest userRequest) {
        try {
            if (0 != this.namedParameterJdbcTemplate.update("DELETE FROM users WHERE id = :userId"
                    , userFacade.toDeleteUser(userRequest)))
                return true;
            else
                return false;
        } catch (Exception e) {
            return false;
        }
    }

    public UserResponse findUserByFirstName(String username) {
        return userFacade.toResponse(userRepository.findUserByFirstName(username).orElseThrow(() -> new RuntimeException("Username not found with username " + username)));
    }
}
