package gdu.user_service.usecase.user.impl;

import gdu.user_service.entity.UserEntity;
import gdu.user_service.exception.NotFoundException;
import gdu.user_service.repository.UserRepository;
import gdu.user_service.usecase.user.DeleteUserUseCase;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@AllArgsConstructor
public class DeleteUserUseCaseImpl implements DeleteUserUseCase {

    private UserRepository userRepository;

    @Override
    public Boolean execute(int userId) {
        UserEntity foundUser = this.userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("User not found"));
        this.userRepository.delete(foundUser);
        return this.userRepository.existsById(userId);
    }
}
