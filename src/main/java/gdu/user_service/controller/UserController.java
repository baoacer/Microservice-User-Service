package gdu.user_service.controller;

import gdu.user_service.model.UserDto;
import gdu.user_service.model.request.CreateUserRequest;
import gdu.user_service.model.request.GetAllUserRequest;
import gdu.user_service.model.request.UpdateUserRequest;
import gdu.user_service.model.response.GetUserResponse;
import gdu.user_service.model.response.ObjectResponse;
import gdu.user_service.usecase.user.*;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/v1")
@AllArgsConstructor
public class UserController {
    private final CreateUserUseCase createUserUseCase;
    private final GetAllUserUseCase getAllUserUseCase;
    private final GetByIdUserUseCase getByIdUserUseCase;
    private final DeleteUserUseCase deleteUserUseCase;
    private final UpdateUserUseCase updateUserUseCase;

    @GetMapping("/user")
    public ResponseEntity<ObjectResponse<GetUserResponse>> getUsers(
            @RequestParam byte size,
            @RequestParam byte page
    ) {
        GetAllUserRequest request = new GetAllUserRequest(size, page);
        ObjectResponse<GetUserResponse> users = this.getAllUserUseCase.execute(request);
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    @GetMapping("/user-by")
    public ResponseEntity<GetUserResponse> getUser(
            @RequestParam int id
    ) {
        GetUserResponse user = this.getByIdUserUseCase.execute(id);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @PostMapping("/user")
    public ResponseEntity<UserDto> createUser(
            @RequestBody CreateUserRequest request
    ) {
        UserDto user = this.createUserUseCase.execute(request);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @PutMapping("/user")
    public ResponseEntity<UserDto> getUsers(
            @RequestBody UpdateUserRequest request
    ) {
        UserDto user = this.updateUserUseCase.execute(request);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @DeleteMapping("/user")
    public ResponseEntity<Boolean> deleteUser(
            @RequestParam int id
    ) {
        Boolean isDeleted = this.deleteUserUseCase.execute(id);
        if(isDeleted){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
