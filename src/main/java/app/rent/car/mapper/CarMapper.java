package app.rent.car.mapper;

import app.rent.car.dto.car.CarDto;
import app.rent.car.dto.car.CreateCarRequestDto;
import app.rent.car.model.car.Car;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        implementationPackage = "<PACKAGE_NAME>.impl")
public interface CarMapper {
    Car toModel(CreateCarRequestDto requestDto);

    CarDto toDto(Car car);

    void update(CreateCarRequestDto requestDto, @MappingTarget Car updatedCar);
}
