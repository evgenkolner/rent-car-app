package app.rent.car.service.user;

import app.rent.car.dto.user.UserRegistrationRequestDto;
import app.rent.car.dto.user.UserRegistrationResponseDto;
import app.rent.car.exception.RegistrationException;

public interface UserService {
    UserRegistrationResponseDto register(UserRegistrationRequestDto requestDto)
            throws RegistrationException;
}
