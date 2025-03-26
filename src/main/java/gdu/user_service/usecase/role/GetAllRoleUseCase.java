package gdu.user_service.usecase.role;

import gdu.user_service.model.RoleDto;
import gdu.user_service.model.request.GetRoleRequest;
import gdu.user_service.model.response.ObjectResponse;

public interface GetAllRoleUseCase {
    ObjectResponse<RoleDto> execute(GetRoleRequest request);
}
