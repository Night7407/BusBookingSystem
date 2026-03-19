package BookingSystem.RedBus.Exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {
    @ExceptionHandler(UserNotFound.class)
    public ResponseEntity<String> handleUserNotFound(UserNotFound userNotFound){
        return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(BusNotFound.class)
    public ResponseEntity<String> handleBusNotFound(BusNotFound busNotFound){
        return new ResponseEntity<>("Bus not found", HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(BookingNotFound.class)
    public ResponseEntity<String> handleBookingNotFound(BookingNotFound bookingNotFound){
        return new ResponseEntity<>("Booking not found", HttpStatus.NOT_FOUND);
    }
}
