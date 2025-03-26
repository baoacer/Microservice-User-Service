package gdu.user_service.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {
    private int id;
    private String email;
    private String password;
    private String phoneNumber;
    private String role;
}
