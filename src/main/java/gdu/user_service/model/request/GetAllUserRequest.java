package gdu.user_service.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.domain.Sort;

@Data
@Builder
public class GetAllUserRequest {
    private byte size;
    private byte page;
    private String sortBy = "id";
    private Sort.Direction sortDirection = Sort.Direction.DESC;
}
