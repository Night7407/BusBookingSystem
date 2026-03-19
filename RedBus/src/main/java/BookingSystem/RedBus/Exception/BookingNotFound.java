package BookingSystem.RedBus.Exception;

public class BookingNotFound extends RuntimeException{
    public BookingNotFound(String message){
        super(message);
    }
}
