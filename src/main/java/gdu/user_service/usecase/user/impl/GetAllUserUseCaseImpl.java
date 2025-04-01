package gdu.user_service.usecase.user.impl;

import gdu.user_service.entity.UserEntity;
import gdu.user_service.model.response.UserResponse;
import gdu.user_service.model.response.ObjectResponse;
import gdu.user_service.repository.UserRepository;
import gdu.user_service.model.request.GetAllUserRequest;
import gdu.user_service.usecase.user.GetAllUserUseCase;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GetAllUserUseCaseImpl implements GetAllUserUseCase {

    private final UserRepository userRepository;

    @Override
    public ObjectResponse<UserResponse> execute(GetAllUserRequest request) {
        Sort sort = Sort.by(request.getSortDirection(), request.getSortBy());
        PageRequest pageable = PageRequest.of(request.getPage(), request.getSize(), sort);

        Page<UserEntity> pageResult = this.userRepository.findAll(pageable);

        List<UserResponse> users = pageResult.getContent().stream().map(
                user -> UserResponse.builder()
                        .id(user.getId())
                        .email(user.getEmail())
                        .phoneNumber(user.getPhoneNumber())
                        .role(user.getRoleEntity().getName())
                        .build()
        ).toList();

        ObjectResponse<UserResponse> response = new ObjectResponse<>();
        response.setContent(users);
        response.setTotalPages(pageResult.getTotalPages());
        response.setTotalElements(pageResult.getTotalElements());
        response.setSize(pageResult.getSize());
        response.setNumber(pageResult.getNumber());

        return response;
    }
}
