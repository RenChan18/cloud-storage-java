package ru.cloud.storage.backendjavacloudstorage.dto.request;

        import lombok.AllArgsConstructor;
        import lombok.Builder;
        import lombok.Data;
        import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String hashPassword;
}