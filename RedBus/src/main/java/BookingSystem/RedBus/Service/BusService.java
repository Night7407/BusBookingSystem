package BookingSystem.RedBus.Service;


import BookingSystem.RedBus.Entity.Bus;
import BookingSystem.RedBus.Entity.User;
import BookingSystem.RedBus.Exception.BusNotFound;
import BookingSystem.RedBus.Repo.BusRepository;
import BookingSystem.RedBus.Repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BusService {

    @Autowired
    BusRepository busRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public String addBus(Bus bus) {
        busRepository.save(bus);
        return "Added Bus";
    }
    public String removeBusId(Long busId) {
        busRepository.deleteById(busId);
        return "Removed Bus Successfully!!";
    }
    public String saveNewAdmin(User admin){
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        admin.setRole("ADMIN");
        userRepository.save(admin);
        return "Saved Admin";
    }
    public String updateBusSeats(Long busId,Integer seats){
        Bus bus = busRepository.findById(busId).orElseThrow(() -> new BusNotFound("Bus not found"));
        bus.setSeats(seats);
        bus.setAvailableSeats(seats);

        busRepository.save(bus);
        return "Updated Bus";



    }
    public List<Bus> viewAllBus(String source, String destination){
        return busRepository.findBySourceAndDestination(source,destination);
    }

}
