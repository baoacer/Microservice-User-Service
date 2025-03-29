package gdu.user_service.usecase.role.impl;

import gdu.user_service.entity.RoleEntity;
import gdu.user_service.repository.RoleRepository;
import gdu.user_service.model.RoleDto;
import gdu.user_service.usecase.role.GetAllRoleUseCase;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class GetAllRoleUseCaseImpl implements GetAllRoleUseCase {

    private final RoleRepository roleRepository;

    @Override
    public List<RoleDto> execute() {

        List<RoleEntity> rolesResult = this.roleRepository.findAll();

        return rolesResult.stream().map(role ->
                RoleDto.builder()
                        .id(role.getId())
                        .name(role.getName())
                        .build()
                ).toList();
    }

}
