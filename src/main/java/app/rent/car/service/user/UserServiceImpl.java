package app.rent.car.service.user;

import app.rent.car.dto.user.UserRegistrationRequestDto;
import app.rent.car.dto.user.UserResponseDto;
import app.rent.car.dto.user.UserRoleUpdateDto;
import app.rent.car.dto.user.UserUpdateDto;
import app.rent.car.exception.EntityNotFoundException;
import app.rent.car.exception.RegistrationException;
import app.rent.car.mapper.UserMapper;
//import app.rent.car.model.user.RoleName;
import app.rent.car.model.user.RoleName;
import app.rent.car.model.user.User;
import app.rent.car.repository.RoleRepository;
import app.rent.car.repository.UserRepository;
import jakarta.transaction.Transactional;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    @Override
    public UserResponseDto register(UserRegistrationRequestDto requestDto)
            throws RegistrationException {
        if (userRepository.existsUserByEmail(requestDto.email())) {
            throw new RegistrationException("This email exists");
        }
        User user = userMapper.toUser(requestDto);
        user.setPassword(passwordEncoder.encode(requestDto.password()));
        user.setEmail(requestDto.email());
        user.setRoles(Set.of(roleRepository.findByName(RoleName.CUSTOMER)));
        User savedUser = userRepository.save(user);
        return userMapper.toResponse(savedUser);
    }

    @Override
    public UserResponseDto update(UserUpdateDto updateRequest) {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByEmail(email).orElseThrow(
                () -> new EntityNotFoundException("User does not exist"));
        userMapper.updateUser(updateRequest, user);
        return userMapper.toResponse(userRepository.save(user));
    }

    @Override
    public UserResponseDto getProfileInfo() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByEmail(email).orElseThrow(
                () -> new EntityNotFoundException("User does not exist"));
        return userMapper.toResponse(user);
    }

    @Transactional
    @Override
    public void updateRole(Long id, UserRoleUpdateDto roleUpdateDto) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("User does not exist")
        );
        userMapper.updateUserRole(roleUpdateDto, user);
        userRepository.save(user);
    }
}
