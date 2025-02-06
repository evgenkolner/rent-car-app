package app.rent.car.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserLoginRequestDto(
        @Email @NotBlank String email,

        @NotBlank @Size(min = 4, max = 20) String password
) {
}
