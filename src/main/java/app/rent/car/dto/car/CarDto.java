package app.rent.car.dto.car;

import app.rent.car.model.car.CarType;
import java.math.BigDecimal;

public record CarDto(Long id,
                     String model,
                     String brand,
                     Integer inventory,
                     BigDecimal dailyFee,
                     CarType carType) {
}
