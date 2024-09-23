package motos.services;

import motos.dto.requests.RegisterRequest;
import motos.dto.response.RegisterResponse;

public interface UserService {
    RegisterResponse register(RegisterRequest registerRequest);
}
