package BookingSystem.RedBus.Service;


import BookingSystem.RedBus.Entity.Booking;
import BookingSystem.RedBus.Entity.Bus;
import BookingSystem.RedBus.Entity.Passenger;
import BookingSystem.RedBus.Entity.User;
import BookingSystem.RedBus.Exception.BookingNotFound;
import BookingSystem.RedBus.Exception.UserNotFound;
import BookingSystem.RedBus.Repo.BookingRepository;
import BookingSystem.RedBus.Repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    BusRepository busRepository;

    public String saveUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("USER");
        userRepository.save(user);
        return "Saved User";
    }
//    public String login(String username, String password){
//        User user  = userRepository.findByUserName(username).orElseThrow(()-> new UserNotFound("User not found"));
//        if(passwordEncoder.matches(password,user.getPassword())){
//            return "Login Successful!!";
//        }
//        return "Wrong Password";
//    }
    public String saveBooking(Booking booking){

        Bus bus = booking.getBus();
        if(bus == null){
            return "Bus not found";
        }
        if(bus.getAvailableSeats()<booking.getTotalSeat()){
            return "Not enough seats Available!!";
        }
        bus.setAvailableSeats(bus.getAvailableSeats()-booking.getTotalSeat());
        bookingRepository.save(booking);
        return "Saved Booking";
    }
    public String addPassenger(Long bookingId,Passenger passenger){
        Booking booking = bookingRepository.findById(bookingId).orElseThrow(() -> new BookingNotFound("Booking not found with id " + bookingId));

        passenger.setBooking(booking);

        booking.getPassengers().add(passenger);
        bookingRepository.save(booking);
        return "Added Passenger!!";

    }

    public List<Passenger> viewAllPassenger(Long bookingId){
         Booking booking = bookingRepository.findById(bookingId).orElseThrow(() -> new BookingNotFound("Booking not found with id " + bookingId));
         return booking.getPassengers();
    }

    public List<Bus> viewAllBus(String source, String destination){
        return busRepository.findBySourceAndDestination(source,destination);
    }




}
