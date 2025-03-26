package gdu.user_service.usecase.role.impl;

import gdu.user_service.entity.RoleEntity;
import gdu.user_service.exception.ConflictException;
import gdu.user_service.model.request.CreateRoleRequest;
import gdu.user_service.repository.RoleRepository;
import gdu.user_service.model.RoleDto;
import gdu.user_service.usecase.role.CreateRoleUseCase;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@AllArgsConstructor
public class CreateRoleUseCaseImpl implements CreateRoleUseCase {
    private final RoleRepository roleRepository;

    @Override
    public RoleDto execute(CreateRoleRequest request) {
        RoleEntity foundRole = this.roleRepository.findByName(request.getRoleName());
        if (foundRole != null) throw new ConflictException("Role already exists");

        RoleEntity role = new RoleEntity();
        role.setName(request.getRoleName());
        RoleEntity saveRole = this.roleRepository.save(role);
        return RoleDto.builder()
                .id(saveRole.getId())
                .name(saveRole.getName())
                .build();
    }
}
