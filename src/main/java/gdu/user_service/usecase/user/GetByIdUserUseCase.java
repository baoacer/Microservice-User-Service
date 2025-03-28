package gdu.user_service.usecase.user;

import gdu.user_service.model.response.UserResponse;

public interface GetByIdUserUseCase {
    UserResponse execute(int id);
}
