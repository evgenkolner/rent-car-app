package app.rent.car.dto.user;

public record UserLoginRequestDto(
        String email,
        String password
) {
}
