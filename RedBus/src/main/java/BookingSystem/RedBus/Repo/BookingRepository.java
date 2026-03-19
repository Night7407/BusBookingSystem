package BookingSystem.RedBus.Repo;

import BookingSystem.RedBus.Entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking,Long> {
}
