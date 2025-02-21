package app.rent.car.dto.user;

import jakarta.validation.constraints.NotNull;

public record UserUpdateDto(
        @NotNull String firstName,
        @NotNull String lastName
) {
}
