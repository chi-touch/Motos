package motos.services;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import motos.dto.requests.RegisterRequest;
import motos.dto.response.RegisterResponse;
import motos.models.User;
import motos.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//@RequiredArgsConstructor
@AllArgsConstructor
public class UserServicelmpl implements UserService {
    private final ModelMapper mapper;
    private final UserRepository userRepository;

    @Override
    public RegisterResponse register(RegisterRequest registerRequest) {
        User user = mapper.map(registerRequest, User.class);
        User savedUser = userRepository.save(user);
        RegisterResponse response = mapper.map(savedUser, RegisterResponse.class);
        response.setMessage("Successfully registered");
        return response;
    }
}
