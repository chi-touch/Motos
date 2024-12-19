package motos.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;


@Setter
@Getter
@Entity
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private Double amountPaid;
    private LocalDateTime travelTime;
    private String destination;
    private String paymentStatus;  // e.g., "Pending", "Completed"
    @ManyToOne
    private Bus bus;
}
