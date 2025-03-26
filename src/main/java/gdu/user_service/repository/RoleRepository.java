package gdu.user_service.repository;

import gdu.user_service.entity.RoleEntity;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Byte> {
    RoleEntity findByName(@NotBlank String roleName);
}
