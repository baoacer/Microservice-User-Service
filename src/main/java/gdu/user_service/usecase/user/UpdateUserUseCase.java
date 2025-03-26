package gdu.user_service.usecase.user;

import gdu.user_service.model.UserDto;
import gdu.user_service.model.request.UpdateUserRequest;

public interface UpdateUserUseCase {
    UserDto execute(UpdateUserRequest request);
}
