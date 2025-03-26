package gdu.user_service.usecase.role;

import gdu.user_service.model.RoleDto;
import gdu.user_service.model.request.CreateRoleRequest;

public interface CreateRoleUseCase {
    RoleDto execute(CreateRoleRequest request);
}
