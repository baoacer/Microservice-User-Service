package gdu.user_service.usecase.user;

import gdu.user_service.model.request.GetAllUserRequest;
import gdu.user_service.model.response.UserResponse;
import gdu.user_service.model.response.ObjectResponse;


public interface GetAllUserUseCase {
    ObjectResponse<UserResponse> execute(GetAllUserRequest request);
}
