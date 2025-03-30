package gdu.user_service.model.request;

import lombok.Data;

@Data
public class CreateUserRequest {
    private String email;

    private String password;

    private String roleName;
}
