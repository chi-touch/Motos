package motos.dto.requests;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class TripRequest {
    private Long id;
    private String destination;
    private Date date;
    private BigDecimal price;
}
