package motos.services;

import motos.dto.requests.BookingRequest;
import motos.dto.requests.RegisterRequest;
import motos.dto.response.BookingResponse;
import motos.dto.response.RegisterResponse;
import motos.models.Customers;

public interface CustomerService {
    RegisterResponse register(RegisterRequest registerRequest);

    BookingResponse bookTrip(BookingRequest bookingRequest);
    Customers findUserByEmail(String email);

}
