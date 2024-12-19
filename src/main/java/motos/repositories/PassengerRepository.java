package motos.repositories;

import motos.models.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Long> {

    List<Passenger> findAllByTravelTimeBetween(LocalDateTime startTime, LocalDateTime endTime);
}
