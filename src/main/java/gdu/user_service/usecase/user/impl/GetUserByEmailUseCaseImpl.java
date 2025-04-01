package gdu.user_service.usecase.user.impl;

import gdu.user_service.entity.UserEntity;
import gdu.user_service.exception.NotFoundException;
import gdu.user_service.model.request.GetUserByEmailRequest;
import gdu.user_service.model.response.UserResponse;
import gdu.user_service.repository.UserRepository;
import gdu.user_service.usecase.user.GetUserByEmailUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GetUserByEmailUseCaseImpl implements GetUserByEmailUseCase {

    private UserRepository userRepository;

    @Override
    public UserResponse execute(GetUserByEmailRequest request) {
        UserEntity foundUser = userRepository.findByEmail(request.getEmail());
        if(foundUser == null) throw new NotFoundException("Email not exist");

        return UserResponse.builder()
                .id(foundUser.getId())
                .email(foundUser.getEmail())
                .phoneNumber(foundUser.getPhoneNumber())
                .role(foundUser.getRoleEntity().getName())
                .build();
    }
}
