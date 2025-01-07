package app.rent.car.model.rental;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Setter
@Getter
@SQLDelete(sql = "UPDATE rentals SET is_deleted = true WHERE id = ?")
@Where(clause = "is_deleted = false")
@Table(name = "rentals")
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate rentalDate;

    @Column(nullable = false)
    private LocalDate returnDate;

    @Column(nullable = false)
    private LocalDate actualReturnDate;

    @Column(nullable = false)
    private Long carId;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private Boolean isDeleted = false;

}
