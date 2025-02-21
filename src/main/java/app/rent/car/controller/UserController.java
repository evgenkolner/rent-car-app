package app.rent.car.controller;

import app.rent.car.dto.user.UserResponseDto;
import app.rent.car.dto.user.UserRoleUpdateDto;
import app.rent.car.dto.user.UserUpdateDto;
import app.rent.car.service.user.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @PreAuthorize("hasAuthority('MANAGER')")
    @PutMapping("/{id}/role")
    public void updateRole(@PathVariable @Positive Long id,
                           @RequestBody @Valid UserRoleUpdateDto roleUpdateDto) {
        userService.updateRole(id, roleUpdateDto);
    }

    @PreAuthorize("hasAuthority('CUSTOMER')")
    @PutMapping("/me")
    public UserResponseDto updateProfile(@RequestBody @Valid UserUpdateDto updateDto) {
        return userService.update(updateDto);
    }

    @PreAuthorize("hasAuthority('CUSTOMER')")
    @GetMapping("/me")
    public UserResponseDto getProfileInfo() {
        return userService.getProfileInfo();
    }
}
