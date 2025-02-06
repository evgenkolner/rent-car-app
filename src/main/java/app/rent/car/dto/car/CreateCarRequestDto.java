package app.rent.car.dto.car;

import app.rent.car.model.car.CarType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public record CreateCarRequestDto(
        @NotNull String model,
        @NotNull String brand,
        @NotNull Integer inventory,
        @NotNull @Min(0) BigDecimal dailyFee,
        @NotNull CarType carType) {
}
