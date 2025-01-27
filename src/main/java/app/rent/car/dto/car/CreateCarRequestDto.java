package app.rent.car.dto.car;

import app.rent.car.model.car.CarType;
import java.math.BigDecimal;

public record CreateCarRequestDto(String model,
                                  String brand,
                                  Integer inventory,
                                  BigDecimal dailyFee,
                                  CarType carType) {
}
