package motos.repositories;

import motos.models.Customers;
import motos.models.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TripRepository extends JpaRepository<Trip, Long> {
    List<Trip> findByCustomers(Customers customer);
}
