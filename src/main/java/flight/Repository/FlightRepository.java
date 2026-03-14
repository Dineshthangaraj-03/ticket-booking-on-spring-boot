package flight.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import flight.Flight;

public interface FlightRepository extends JpaRepository<Flight, Integer> {}
