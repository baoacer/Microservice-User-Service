package gdu.user_service.usecase.user;

import gdu.user_service.model.UserDto;
import gdu.user_service.model.response.GetUserResponse;

public interface GetByIdUserUseCase {
    GetUserResponse execute(int id);
}
