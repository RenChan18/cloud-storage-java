package ru.cloud.storage.backendjavacloudstorage.facade;


        import lombok.RequiredArgsConstructor;
        import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
        import org.springframework.stereotype.Component;
        import ru.cloud.storage.backendjavacloudstorage.dto.request.UserRequest;
        import ru.cloud.storage.backendjavacloudstorage.dto.response.UserResponse;
        import ru.cloud.storage.backendjavacloudstorage.model.User;

@Component
@RequiredArgsConstructor
public class UserFacade {
    public UserResponse toResponse(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .hashPassword(user.getHashPassword())
                .build();
    }

    public MapSqlParameterSource toCreateUser(UserRequest userRequest) {
        MapSqlParameterSource in = new MapSqlParameterSource();
        in.addValue("firstname", userRequest.getFirstName());
        in.addValue("lastname", userRequest.getLastName());
        in.addValue("email", userRequest.getEmail());
        in.addValue("hashpassword", userRequest.getHashPassword());
        return in;
    }

    public MapSqlParameterSource toUpdateUser(UserRequest userRequest) {
        MapSqlParameterSource in = new MapSqlParameterSource();
        in.addValue("userId", userRequest.getId()); // предполагая, что у вас есть метод getUserId() в UserRequest
        in.addValue("firstname", userRequest.getFirstName());
        in.addValue("lastname", userRequest.getLastName());
        in.addValue("email", userRequest.getEmail());
        in.addValue("hashpassword", userRequest.getHashPassword());
        return in;
    }


    public MapSqlParameterSource toDeleteUser(UserRequest userRequest) {
        MapSqlParameterSource in = new MapSqlParameterSource();
        in.addValue("userId", userRequest.getId());
        return in;
    }

    public User toUser(UserRequest userRequest) {
        User user = new User();
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        user.setEmail(userRequest.getEmail());
        user.setHashPassword(userRequest.getHashPassword());
        return user;
    }

}