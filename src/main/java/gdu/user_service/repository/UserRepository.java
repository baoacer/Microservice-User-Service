package gdu.user_service.repository;

import gdu.user_service.entity.UserEntity;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    UserEntity findByEmail(@NotBlank String email);

    Boolean existsByEmail(@NotBlank String email);

    Boolean existsByPhoneNumber(@NotBlank String phoneNumber);

    Page<UserEntity> findAll(@NotBlank Pageable pageable);
}
