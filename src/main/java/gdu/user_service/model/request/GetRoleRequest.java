package gdu.user_service.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetRoleRequest {
    private byte size;
    private byte page;
}
