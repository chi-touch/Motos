package motos.dto.requests;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BookingRequest {
    private String name;
    private String phoneNumber;
    private String email;
    private String sitNumber;
    private String destination;
}
