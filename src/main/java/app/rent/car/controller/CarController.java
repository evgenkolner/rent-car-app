package app.rent.car.controller;

import app.rent.car.dto.car.CarDto;
import app.rent.car.dto.car.CreateCarRequestDto;
import app.rent.car.service.car.CarService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/cars")
public class CarController {
    private final CarService carService;

    @PostMapping
    public CarDto save(@RequestBody CreateCarRequestDto requestDto) {
        return carService.save(requestDto);
    }

    @GetMapping
    public List<CarDto> findAll() {
        return carService.findAll();
    }

    @GetMapping("/{id}")
    public CarDto findById(@PathVariable Long id) {
        return carService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        carService.deleteById(id);
    }

    @PutMapping("/{id}")
    public CarDto update(@RequestBody CreateCarRequestDto requestDto, @PathVariable Long id) {
        return carService.update(requestDto, id);
    }
}
