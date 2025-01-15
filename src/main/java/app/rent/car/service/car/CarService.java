package app.rent.car.service.car;

import app.rent.car.dto.car.CarDto;
import app.rent.car.dto.car.CreateCarRequestDto;
import java.util.List;

public interface CarService {
    CarDto save(CreateCarRequestDto requestDto);

    List<CarDto> findAll();

    CarDto findById(Long id);

    void deleteById(Long id);

    CarDto update(CreateCarRequestDto requestDto, Long id);
}
