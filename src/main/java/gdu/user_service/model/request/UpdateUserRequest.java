package gdu.user_service.model.request;

import lombok.Data;

@Data
public class UpdateUserRequest {
    private int userId;
    private String email;
    private String password;
    private String phoneNumber;
}
