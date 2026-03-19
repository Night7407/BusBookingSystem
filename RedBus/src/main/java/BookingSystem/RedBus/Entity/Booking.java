package BookingSystem.RedBus.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookingId;
    private String source;
    private String destination;
    private Integer totalSeat;

    @ManyToOne
    @JoinColumn(name="bus_id")
    private Bus bus;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @OneToMany(mappedBy = "booking",cascade = CascadeType.ALL)
    private List<Passenger> passengers;
}
