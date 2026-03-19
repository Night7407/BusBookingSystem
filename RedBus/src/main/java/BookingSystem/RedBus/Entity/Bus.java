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
public class Bus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long busId;
    private String busName;
    private String busNo;
    private String source;
    private String destination;
    private Double fare;
    private Integer seats;
    private Integer availableSeats;

    @OneToMany(mappedBy = "bus",cascade = CascadeType.ALL)
    private List<Booking> bookings;

}
