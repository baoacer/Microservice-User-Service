package gdu.user_service.usecase.user.impl;

import gdu.user_service.entity.UserEntity;
import gdu.user_service.exception.ConflictException;
import gdu.user_service.exception.NotFoundException;
import gdu.user_service.repository.UserRepository;
import gdu.user_service.model.UserDto;
import gdu.user_service.model.request.UpdateUserRequest;
import gdu.user_service.usecase.user.UpdateUserUseCase;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@AllArgsConstructor
public class UpdateUserUseCaseImpl implements UpdateUserUseCase {
    private final UserRepository userRepository;

    @Override
    public UserDto execute(UpdateUserRequest request) {
        UserEntity user = new UserEntity();

        UserEntity foundUser = this.userRepository.findById(request.getUserId())
                .orElseThrow(() -> new NotFoundException("User not found"));

        if(request.getEmail() != null){
            Boolean isExists = this.userRepository.existsByEmail(request.getEmail());
            if(isExists) throw new ConflictException("Email already exists");
            user.setEmail(request.getEmail());
        }

        if(request.getPassword() != null){
            user.setPassword(request.getPassword());
        }

        if(request.getPhoneNumber() != null){
            if(foundUser.getPhoneNumber() != request.getPhoneNumber()){
                Boolean phoneNumberIsExists = this.userRepository.existsByPhoneNumber(request.getPhoneNumber());
                if(phoneNumberIsExists) throw new ConflictException("Phone number already exists");
                user.setPhoneNumber(request.getPhoneNumber());
            }
        }

        UserEntity savedUser = this.userRepository.save(user);

        return UserDto.builder()
                .email(savedUser.getEmail())
                .phoneNumber(savedUser.getPhoneNumber())
                .password(savedUser.getPassword())
                .role(savedUser.getRoleEntity().getName())
                .build();
    }
}
