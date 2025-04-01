package gdu.user_service.usecase.user;

import gdu.user_service.model.request.GetUserByEmailRequest;
import gdu.user_service.model.response.GetUserByEmailResponse;

public interface GetUserByEmailUseCase {
    GetUserByEmailResponse execute(GetUserByEmailRequest request);
}
