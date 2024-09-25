package motos.services;

import motos.dto.requests.TripRequest;
import motos.dto.response.TripResponse;
import motos.models.Customers;
import motos.models.Trip;
import motos.repositories.TripRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripServiceImpl implements TripService {

    private ModelMapper modelMapper;
    @Autowired
    private TripRepository tripRepository;

    public TripResponse bookTrip(TripRequest tripRequest){
        Trip trip = modelMapper.map(tripRequest, Trip.class);
        tripRepository.save(trip);
        TripResponse tripResponse = modelMapper.map(trip, TripResponse.class);
        return tripResponse;
    }

    public List<Trip> getTripsByCustomer(Customers customer) {
        return tripRepository.findByCustomers(customer);
    }

}
