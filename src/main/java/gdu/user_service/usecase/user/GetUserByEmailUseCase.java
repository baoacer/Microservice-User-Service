package gdu.user_service.usecase.user;

import gdu.user_service.model.request.GetUserByEmailRequest;
import gdu.user_service.model.response.UserResponse;

public interface GetUserByEmailUseCase {
    UserResponse execute(GetUserByEmailRequest request);
}
