package app.rent.car.service.rental;

import app.rent.car.dto.rental.CreateRentalRequestDto;
import app.rent.car.dto.rental.RentalDto;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class RentalServiceImpl implements RentalService {
    @Override
    public RentalDto save(CreateRentalRequestDto requestDto) {
        return null;
    }

    @Override
    public List<RentalDto> getAllByUserIdAndIsActive(Long userId, boolean isActive) {
        return null;
    }

    @Override
    public RentalDto getRentalById(Long id) {
        return null;
    }

    @Override
    public RentalDto addActualReturnTime(Long id) {
        return null;
    }
}
