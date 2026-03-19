package BookingSystem.RedBus.Exception;

public class BusNotFound extends RuntimeException{
    public BusNotFound(String message){
        super(message);
    }
}
