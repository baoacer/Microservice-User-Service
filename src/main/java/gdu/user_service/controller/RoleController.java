package gdu.user_service.controller;

import gdu.user_service.model.RoleDto;
import gdu.user_service.model.request.CreateRoleRequest;
import gdu.user_service.model.response.ObjectResponse;
import gdu.user_service.usecase.role.CreateRoleUseCase;
import gdu.user_service.usecase.role.DeleteRoleUseCase;
import gdu.user_service.usecase.role.GetAllRoleUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/v1")
@AllArgsConstructor
public class RoleController {

    private final CreateRoleUseCase createRoleUseCase;
    private final GetAllRoleUseCase getAllRoleUseCase;
    private final DeleteRoleUseCase deleteRoleUseCase;

    @GetMapping("/role")
    public ResponseEntity<List<RoleDto>> getRoles() {
        List<RoleDto> roles = this.getAllRoleUseCase.execute();
        return ResponseEntity.status(HttpStatus.OK).body(roles);
    }

    @PostMapping("/role")
    public ResponseEntity<RoleDto> createRole(
            @RequestBody CreateRoleRequest request
    ) {
        RoleDto role = this.createRoleUseCase.execute(request);
        return ResponseEntity.status(HttpStatus.OK).body(role);
    }

    @DeleteMapping("/role")
    public ResponseEntity<Boolean> deleteRole(
            @RequestParam byte id
    ) {
        Boolean isDeleted = this.deleteRoleUseCase.execute(id);
        if(isDeleted){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
