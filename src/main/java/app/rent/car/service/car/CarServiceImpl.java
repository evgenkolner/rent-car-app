package app.rent.car.service.car;

import app.rent.car.dto.car.CarDto;
import app.rent.car.dto.car.CreateCarRequestDto;
import app.rent.car.exception.EntityNotFoundException;
import app.rent.car.mapper.CarMapper;
import app.rent.car.model.car.Car;
import app.rent.car.repository.CarRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;
    private final CarMapper carMapper;

    @Override
    public CarDto save(CreateCarRequestDto requestDto) {
        Car car = carMapper.toModel(requestDto);
        Car savedCar = carRepository.save(car);
        return carMapper.toDto(savedCar);
    }

    @Override
    public List<CarDto> findAll() {
        return carRepository.findAll()
                .stream()
                .map(carMapper::toDto)
                .toList();
    }

    @Override
    public CarDto findById(Long id) {
        return carMapper.toDto(carRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Can`t find car by id" + id)));
    }

    @Override
    public void deleteById(Long id) {
        carRepository.deleteById(id);
    }

    @Override
    public CarDto update(CreateCarRequestDto requestDto, Long id) {
        Car carById = carRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Can`t find car by id" + id));
        carMapper.update(requestDto, carById);
        carById.setId(id);
        return carMapper.toDto(carRepository.save(carById));
    }
}
