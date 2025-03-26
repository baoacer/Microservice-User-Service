package gdu.user_service.usecase.user;

import gdu.user_service.model.UserDto;
import gdu.user_service.model.request.GetAllUserRequest;
import gdu.user_service.model.response.GetUserResponse;
import gdu.user_service.model.response.ObjectResponse;
import org.springframework.data.domain.Page;


public interface GetAllUserUseCase {
    ObjectResponse<GetUserResponse> execute(GetAllUserRequest request);
}
