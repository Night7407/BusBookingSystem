package BookingSystem.RedBus.Controller;

import BookingSystem.RedBus.Entity.User;
import BookingSystem.RedBus.Service.BookingService;
import BookingSystem.RedBus.Service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class LoginController {
    @Autowired
    BookingService bookingService;



    @PostMapping("/create")
    public String createUser(@RequestBody User user){
        return bookingService.saveUser(user);
    }

}
