package app.rent.car.repository;

import app.rent.car.model.car.Car;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    Optional<Car> findById(Long id);
}
