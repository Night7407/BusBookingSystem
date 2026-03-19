package BookingSystem.RedBus.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import BookingSystem.RedBus.Entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByUserName(String username);
}
