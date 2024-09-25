package motos.services;

import motos.dto.requests.TripRequest;
import motos.dto.response.TripResponse;
import motos.models.Customers;
import motos.models.Trip;

import java.util.List;

public interface TripService {
    TripResponse bookTrip(TripRequest tripRequest);
    List<Trip> getTripsByCustomer(Customers customer);
}
