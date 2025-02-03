package app.rent.car.service.user;

import app.rent.car.dto.user.UserRegistrationRequestDto;
import app.rent.car.dto.user.UserRegistrationResponseDto;
import app.rent.car.exception.RegistrationException;
import app.rent.car.mapper.UserMapper;
import app.rent.car.model.user.User;
import app.rent.car.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserRegistrationResponseDto register(UserRegistrationRequestDto requestDto)
            throws RegistrationException {
        if (userRepository.existsUserByEmail(requestDto.email())) {
            throw new RegistrationException("This email exists");
        }
        User user = userMapper.toUser(requestDto);
        user.setEmail(requestDto.email());
        user.setPassword(requestDto.password());
        User savedUser = userRepository.save(user);
        return userMapper.toResponse(savedUser);
    }
}
