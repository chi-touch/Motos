package motos.servicetest;

import motos.dto.requests.BookingRequest;
import motos.dto.requests.RegisterRequest;
import motos.dto.response.BookingResponse;
import motos.dto.response.RegisterResponse;
import motos.models.Booking;
import motos.services.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@SpringBootTest
public class CustomerTest {
    @Autowired
    private CustomerService userService;
    @Test
    public void testToRegister(){
        RegisterRequest registerRequest = getRegisterRequest();
        RegisterResponse response = userService.register(registerRequest);
        assertThat(response.getMessage(), is("Successfully registered"));
    }

    private static RegisterRequest getRegisterRequest() {
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setEmail("email");
        registerRequest.setName("name");
        registerRequest.setPassword("password");
        registerRequest.setPhoneNumber("phoneNumber");
        return registerRequest;
    }

    @Test
    public void testUserCanBookTrip(){
        RegisterRequest registerRequest = getRegisterRequest();
        userService.register(registerRequest);
        BookingRequest request = getBookingRequest();
        BookingResponse response = userService.bookTrip(request);
        assertThat(response.getSitNumber(), equalTo("1a"));
        assertThat(response.getMessage(),is("booking successful"));

    }

    private static BookingRequest getBookingRequest() {
        BookingRequest request = new BookingRequest();
        request.setEmail("email");
        request.setName("name");
        request.setPhoneNumber("phoneNumber");
        request.setDestination("destination");
        request.setSitNumber("1a");
        return request;
    }

    @Test
    public void testCustomerCanCancelBooking(){
        RegisterRequest registerRequest = getRegisterRequest();
        userService.register(registerRequest);
        BookingRequest request = getBookingRequest();
        userService.bookTrip(request);
        CancelRequest cancelRequest = new CancelRequest();
        cancelRequest.
    }

}
