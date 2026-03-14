package flight.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import flight.Flight;
import flight.service.FlightService;

@RestController
@RequestMapping("/flight")
@CrossOrigin(origins = "http://localhost:5173") // Allow React frontend
public class Flightcontroll {

    @Autowired
    private FlightService service;
    
    @PostMapping("/save")
    public Flight addFlight(@RequestBody Flight flight) {
        return service.saveFlight(flight);
    }
    
    @PutMapping("/update/{id}")
    public Flight updateFlight(@PathVariable int id, @RequestBody Flight flight) {
        return service.updateFlight(id, flight);
    }



    @GetMapping("/all")
    public List<Flight> getAllFlights() {
        return service.getAllFlights();
    }

    @GetMapping("/{id}")
    public Flight getFlight(@PathVariable int id) {
        return service.getFlightById(id);
    }

   
   
    @DeleteMapping("/delete/{id}")
    public void deleteFlight(@PathVariable int id) {
        service.deleteFlight(id);
    }
}
