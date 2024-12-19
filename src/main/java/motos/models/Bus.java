package motos.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String busNumber;
    private String driverName;
    private String currentLocation; // e.g., GPS coordinates

    @OneToMany
    private List<Booking> bookings;
    @OneToMany(mappedBy = "bus")
    private List<Passenger> passengers;
}
