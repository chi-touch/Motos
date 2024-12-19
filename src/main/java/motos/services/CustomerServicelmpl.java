package motos.services;

import lombok.AllArgsConstructor;
import motos.dto.requests.BookingRequest;
import motos.dto.requests.RegisterRequest;
import motos.dto.response.BookingResponse;
import motos.dto.response.RegisterResponse;
import motos.exceptions.InvalidUserException;
import motos.exceptions.UserExistException;
import motos.models.Booking;
import motos.models.Customers;
import motos.repositories.BookingRepository;
import motos.repositories.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
//@RequiredArgsConstructor
@AllArgsConstructor
public class CustomerServicelmpl implements CustomerService {
    private final ModelMapper mapper;
    private final CustomerRepository userRepository;
    private final BookingRepository bookingRepository;

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

    public Customers findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public BookingResponse bookTrip(BookingRequest bookingRequest) {
        Customers foundUser = findUserByEmail(bookingRequest.getEmail());
        if (foundUser == null){
            throw new InvalidUserException("This user does not exist");
        }
        Booking booking = mapper.map(bookingRequest, Booking.class);
        Booking saveBooking = bookingRepository.save(booking);
        BookingResponse response = mapper.map(saveBooking, BookingResponse.class);
        response.setMessage("booking successful");
        response.setSitNumber(booking.getSitNumber());
        return response;
    }





}
