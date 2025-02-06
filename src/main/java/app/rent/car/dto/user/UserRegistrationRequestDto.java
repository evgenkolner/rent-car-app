package app.rent.car.dto.user;

import app.rent.car.validation.FieldMatch;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@FieldMatch(message = "Password should match",
        field = "password",
        fieldToMatch = "repeatPassword")
public record UserRegistrationRequestDto(
        @Email @NotBlank String email,
        @NotBlank String firstName,
        @NotBlank String lastName,
        @NotBlank @Size(min = 4, max = 20) String password,
        @NotBlank @Size(min = 4, max = 20) String repeatPassword
) {
}
