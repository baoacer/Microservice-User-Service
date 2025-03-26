package gdu.user_service.usecase.role.impl;

import gdu.user_service.entity.RoleEntity;
import gdu.user_service.exception.NotFoundException;
import gdu.user_service.repository.RoleRepository;
import gdu.user_service.usecase.role.DeleteRoleUseCase;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@AllArgsConstructor
public class DeleteRoleUseCaseImpl implements DeleteRoleUseCase {
    private RoleRepository roleRepository;

    @Override
    public Boolean execute(byte roleId) {
        RoleEntity foundRole = roleRepository.findById(roleId)
                .orElseThrow(() -> new NotFoundException("Role not found"));
        this.roleRepository.delete(foundRole);

        return roleRepository.existsById(foundRole.getId());
    }
}
