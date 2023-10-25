package ru.cloud.storage.backendjavacloudstorage.service;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import ru.cloud.storage.backendjavacloudstorage.dto.request.UserRequest;
import ru.cloud.storage.backendjavacloudstorage.dto.response.UserResponse;
import ru.cloud.storage.backendjavacloudstorage.facade.UserFacade;
import ru.cloud.storage.backendjavacloudstorage.model.User;
import ru.cloud.storage.backendjavacloudstorage.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService implements BaseService<UserRequest, UserResponse> {
    private final UserFacade userFacade;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final UserRepository userRepository;

    public Integer createUserWithJDBC(UserRequest userRequest) {
        try {
            return this.namedParameterJdbcTemplate.update("insert into users (firstname, lastname, email, hashpassword)  values (:firstname, :lastname, :email, :hashpassword);", userFacade.toCreateUser(userRequest));
        } catch (Exception e) {
            return 0;
        }
    }
    public User createUserWithJPA(UserRequest userRequest) {
        try {
            return this.userRepository.save(userFacade.toUser(userRequest));
        } catch (Exception e) {
            return new User();
        }
    }


    @Override
    public UserResponse getReferenceById(String id) {
        return null;
    }

    @Override
    public UserResponse create(UserRequest request) {
        return null;
    }

    @Override
    public UserResponse update(UserRequest request) {
        return null;
    }

    @Override
    public Boolean delete(String id) {
        return null;
    }

    public UserResponse findUserByFirstName(String username) {
        return userFacade.toResponse(userRepository.findUserByFirstName(username).orElseThrow(() -> new RuntimeException("Username not found with username " + username)));
    }

}
