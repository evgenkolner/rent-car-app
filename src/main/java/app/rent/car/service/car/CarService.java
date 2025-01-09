package app.rent.car.service.car;

import app.rent.car.dto.car.CarDto;
import app.rent.car.dto.car.CreateCarRequestDto;
import app.rent.car.model.car.Car;
import java.util.List;

public interface CarService {
    Car save(CreateCarRequestDto requestDto);

    List<CarDto> findAll();

    CarDto findById(Long id);

    void deleteById(Long id);

    CarDto update(CreateCarRequestDto requestDto, Long id);
}
