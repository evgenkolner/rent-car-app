package app.rent.car.service.user;

import app.rent.car.dto.user.UserRegistrationRequestDto;
import app.rent.car.dto.user.UserResponseDto;
import app.rent.car.dto.user.UserRoleUpdateDto;
import app.rent.car.dto.user.UserUpdateDto;
import app.rent.car.exception.RegistrationException;

public interface UserService {
    UserResponseDto register(UserRegistrationRequestDto requestDto)
            throws RegistrationException;

    UserResponseDto update(UserUpdateDto updateRequest);

    UserResponseDto getProfileInfo();

    void updateRole(Long id, UserRoleUpdateDto roleUpdateDto);
}
