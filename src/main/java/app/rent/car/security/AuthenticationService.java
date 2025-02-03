package app.rent.car.security;

import app.rent.car.dto.user.UserLoginRequestDto;
import app.rent.car.model.user.User;
import app.rent.car.repository.UserRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;

    public boolean login(UserLoginRequestDto requestDto) {
        Optional<User> user = userRepository.findByEmail(requestDto.email());
        return (user.isPresent() && user.get().getPassword().equals(requestDto.password()));
    }
}
