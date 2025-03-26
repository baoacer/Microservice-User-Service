package gdu.user_service.usecase.user.impl;

import gdu.user_service.entity.RoleEntity;
import gdu.user_service.entity.UserEntity;
import gdu.user_service.exception.NotFoundException;
import gdu.user_service.repository.RoleRepository;
import gdu.user_service.repository.UserRepository;
import gdu.user_service.model.UserDto;
import gdu.user_service.model.request.CreateUserRequest;
import gdu.user_service.usecase.user.CreateUserUseCase;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Transactional
@AllArgsConstructor
public class CreateUserUseCaseImpl implements CreateUserUseCase {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    public UserDto execute(CreateUserRequest request) {
        UserEntity foundUser = this.userRepository.findByEmail(request.getEmail());
        if(foundUser != null) throw new NotFoundException("User not found");

        RoleEntity userRole = this.roleRepository.findByName("ROLE_USER");

        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        UserEntity user = new UserEntity();
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setPhoneNumber(request.getPhoneNumber());
        user.setRoleEntity(userRole);

        UserEntity saveUser = this.userRepository.save(user);

        return UserDto.builder()
                .id(saveUser.getId())
                .email(saveUser.getEmail())
                .phoneNumber(saveUser.getPhoneNumber())
                .password(saveUser.getPassword())
                .role(saveUser.getRoleEntity().getName())
                .build();
    }
}
