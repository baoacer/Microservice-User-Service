package gdu.user_service.usecase.user.impl;

import gdu.user_service.entity.RoleEntity;
import gdu.user_service.entity.UserEntity;
import gdu.user_service.exception.ConflictException;
import gdu.user_service.exception.NotFoundException;
import gdu.user_service.repository.RoleRepository;
import gdu.user_service.repository.UserRepository;
import gdu.user_service.model.UserDto;
import gdu.user_service.model.request.UpdateUserRequest;
import gdu.user_service.usecase.user.UpdateUserUseCase;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Transactional
@AllArgsConstructor
public class UpdateUserUseCaseImpl implements UpdateUserUseCase {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    public UserDto execute(UpdateUserRequest request) {

        UserEntity foundUser = this.userRepository.findById(request.getUserId())
                .orElseThrow(() -> new NotFoundException("User not found"));

        if(request.getEmail() != null){
            Boolean isExists = this.userRepository.existsByEmail(request.getEmail());
            if(isExists) throw new ConflictException("Email already exists");
            foundUser.setEmail(request.getEmail());
        }

        if(request.getPhoneNumber() != null && !request.getPhoneNumber().equals(foundUser.getPhoneNumber())) {
            Boolean phoneNumberIsExists = this.userRepository.existsByPhoneNumber(request.getPhoneNumber());
            if(phoneNumberIsExists) throw new ConflictException("Phone number already exists");
            foundUser.setPhoneNumber(request.getPhoneNumber());
        }

        if(request.getRole() != null){
            RoleEntity foundRole = this.roleRepository.findByName(request.getRole());
            if(foundRole == null) throw new NotFoundException("Role not found");
            foundUser.setRoleEntity(foundRole);
        }

        UserEntity savedUser = this.userRepository.save(foundUser);

        return UserDto.builder()
                .id(savedUser.getId())
                .email(savedUser.getEmail())
                .phoneNumber(savedUser.getPhoneNumber())
                .password(savedUser.getPassword())
                .role(savedUser.getRoleEntity().getName())
                .build();
    }
}
