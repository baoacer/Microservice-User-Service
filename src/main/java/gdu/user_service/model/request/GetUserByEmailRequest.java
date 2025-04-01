package gdu.user_service.model.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetUserByEmailRequest {
    private String email;
}
