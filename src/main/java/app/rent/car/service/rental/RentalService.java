package app.rent.car.service.rental;

import app.rent.car.dto.rental.CreateRentalRequestDto;
import app.rent.car.dto.rental.RentalDto;
import java.util.List;

public interface RentalService {
    RentalDto save(CreateRentalRequestDto requestDto);

    List<RentalDto> getAllByUserIdAndIsActive(Long userId, boolean isActive);

    RentalDto getRentalById(Long id);

    RentalDto addActualReturnTime(Long id);
}
