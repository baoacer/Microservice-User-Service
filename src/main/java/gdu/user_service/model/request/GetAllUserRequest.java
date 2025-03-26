package gdu.user_service.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetAllUserRequest {
    private byte size;
    private byte page;
}
