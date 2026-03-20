package BookingSystem.RedBus.Controller;


import BookingSystem.RedBus.Entity.Booking;
import BookingSystem.RedBus.Entity.Passenger;
import BookingSystem.RedBus.Entity.User;
import BookingSystem.RedBus.Service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    BookingService bookingService;


    @GetMapping("/view/{source}/{destination}")
    public List<Bus> findBySourceAndDestination(@PathVariable String source, @PathVariable String destination) {
        return bookingService.viewAllBus(source,destination);
    }
    @PostMapping("/booking")
    public String booking(@RequestBody Booking booking){
        return bookingService.saveBooking(booking);
    }
    @PostMapping("/passenger/{bookingId}")
    public String addPassenger(@PathVariable Long bookingId, @RequestBody Passenger passenger){
        return bookingService.addPassenger(bookingId, passenger);
    }

    @GetMapping("/passenger/{bookingId}")
    public List<Passenger> getPassengers(@PathVariable Long bookingId){
        return bookingService.viewAllPassenger(bookingId);
    }
}
