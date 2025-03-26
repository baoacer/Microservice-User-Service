package gdu.user_service.usecase.user;

import gdu.user_service.model.UserDto;
import gdu.user_service.model.request.CreateUserRequest;

public interface CreateUserUseCase {
    UserDto execute(CreateUserRequest request);
}
