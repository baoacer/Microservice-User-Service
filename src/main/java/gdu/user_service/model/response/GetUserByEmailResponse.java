package gdu.user_service.model.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetUserByEmailResponse {
    private int id;
    private String email;
    private String phoneNumber;
    private String password;
    private String role;
}
