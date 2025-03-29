package gdu.user_service.usecase.role;

import gdu.user_service.model.RoleDto;

import java.util.List;

public interface GetAllRoleUseCase {
    List<RoleDto> execute();
}
