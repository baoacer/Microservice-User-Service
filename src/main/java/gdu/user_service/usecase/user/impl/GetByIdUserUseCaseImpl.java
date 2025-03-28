package gdu.user_service.usecase.user.impl;

import gdu.user_service.entity.UserEntity;
import gdu.user_service.exception.NotFoundException;
import gdu.user_service.model.response.UserResponse;
import gdu.user_service.repository.UserRepository;
import gdu.user_service.usecase.user.GetByIdUserUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GetByIdUserUseCaseImpl implements GetByIdUserUseCase {

    private final UserRepository userRepository;

    @Override
    public UserResponse execute(int id) {
        UserEntity user = this.userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found"));

        return UserResponse.builder()
                .id(user.getId())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .role(user.getRoleEntity().getName())
                .build();
    }
}
