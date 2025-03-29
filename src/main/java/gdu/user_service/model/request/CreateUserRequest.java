package gdu.user_service.model.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
public class CreateUserRequest {
    @NotBlank
    private String email;

    @NotBlank
    private String password;
}
