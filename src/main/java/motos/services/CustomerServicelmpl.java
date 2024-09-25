package motos.services;

import lombok.AllArgsConstructor;
import motos.dto.requests.RegisterRequest;
import motos.dto.response.RegisterResponse;
import motos.exceptions.UserExistException;
import motos.models.Customers;
import motos.repositories.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
//@RequiredArgsConstructor
@AllArgsConstructor
public class CustomerServicelmpl implements CustomerService {
    private final ModelMapper mapper;
    private final CustomerRepository userRepository;

    @Override
    public RegisterResponse register(RegisterRequest registerRequest) {
        Customers foundUser = userRepository.findByEmail(registerRequest.getEmail());
        if (foundUser == null) {
            Customers user = mapper.map(registerRequest, Customers.class);
            Customers savedUser = userRepository.save(user);
            RegisterResponse response = mapper.map(savedUser, RegisterResponse.class);
            response.setMessage("Successfully registered");
            return response;
        }
        throw new UserExistException("User already exists");
    }


}
