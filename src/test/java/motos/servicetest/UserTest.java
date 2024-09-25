package motos.servicetest;

import motos.dto.requests.RegisterRequest;
import motos.dto.response.RegisterResponse;
import motos.services.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest
public class UserTest {
    @Autowired
    private CustomerService userService;
    @Test
    public void testToRegister(){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setEmail("email");
        registerRequest.setName("name");
        registerRequest.setPassword("password");
        registerRequest.setPhoneNumber("phoneNumber");
        RegisterResponse response = userService.register(registerRequest);
        assertThat(response.getMessage(), is("Successfully registered"));
    }

}
