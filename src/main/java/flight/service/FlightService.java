package flight.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import flight.Flight;
import flight.Repository.FlightRepository;


@Service
public class FlightService {

    @Autowired
    private FlightRepository repository;

    public Flight saveFlight(Flight flight) {
        return repository.save(flight);
    }

    public List<Flight> getAllFlights() {
        return repository.findAll();
    }

    public Flight getFlightById(int id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Flight not found"));
    }

    public Flight updateFlight(int id, Flight flight) {
        Flight existing = repository.findById(id).orElseThrow(() -> new RuntimeException("Flight not found"));
        existing.setName(flight.getName());
        existing.setPrice(flight.getPrice());
        return repository.save(existing);
    }

    public void deleteFlight(int id) {
        repository.deleteById(id);
    }
}
