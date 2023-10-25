package ru.cloud.storage.backendjavacloudstorage.dto.response;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class UserResponse implements Serializable {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String hashPassword;
}
