package gdu.user_service.usecase.role.impl;

import gdu.user_service.entity.RoleEntity;
import gdu.user_service.model.response.ObjectResponse;
import gdu.user_service.repository.RoleRepository;
import gdu.user_service.model.RoleDto;
import gdu.user_service.model.request.GetRoleRequest;
import gdu.user_service.usecase.role.GetAllRoleUseCase;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class GetAllRoleUseCaseImpl implements GetAllRoleUseCase {

    private final RoleRepository roleRepository;

    @Override
    public ObjectResponse<RoleDto> execute(GetRoleRequest request) {
        PageRequest pageable = PageRequest.of(request.getPage(), request.getSize());

        Page<RoleEntity> pageResult = this.roleRepository.findAll(pageable);

        List<RoleDto> roles = pageResult.getContent().stream().map(role ->
                RoleDto.builder()
                        .id(role.getId())
                        .name(role.getName())
                        .build()
                ).toList();

        ObjectResponse<RoleDto> response = new ObjectResponse<>();
        response.setContent(roles);
        response.setTotalPages(pageResult.getTotalPages());
        response.setTotalElements(pageResult.getTotalElements());
        response.setSize(pageResult.getSize());
        response.setSize(pageResult.getSize());

        return response;
    }

}
