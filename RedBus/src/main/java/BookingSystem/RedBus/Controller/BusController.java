package BookingSystem.RedBus.Controller;


import BookingSystem.RedBus.Entity.Bus;
import BookingSystem.RedBus.Entity.User;
import BookingSystem.RedBus.Service.BookingService;
import BookingSystem.RedBus.Service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/buses")
public class BusController {

    @Autowired
    BusService busservice;
    @Autowired
    BookingService bookingService;

    @PostMapping("/add")
    public String addBus(@RequestBody Bus bus) {
        return busservice.addBus(bus);
    }
    @PostMapping("/newAdmin")
    public String newAdmin(@RequestBody User user) {
        return busservice.saveNewAdmin(user);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteBus(@PathVariable Long id) {
        busservice.removeBusId(id);
        return "Deleted Bus Successfully!!";
    }
    @PutMapping("update/{id}/{seats}")
    public String updateBus(@PathVariable Long id,@PathVariable int seats){
        return busservice.updateBusSeats(id,seats);

    }



}
