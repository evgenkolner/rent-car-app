package app.rent.car.mapper;

import app.rent.car.dto.user.UserRegistrationRequestDto;
import app.rent.car.dto.user.UserResponseDto;
import app.rent.car.dto.user.UserRoleUpdateDto;
import app.rent.car.dto.user.UserUpdateDto;
import app.rent.car.model.user.Role;
import app.rent.car.model.user.User;
import java.util.stream.Collectors;
import org.mapstruct.AfterMapping;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        implementationPackage = "<PACKAGE_NAME>.impl")
public interface UserMapper {
    UserResponseDto toResponse(User user);

    User toUser(UserRegistrationRequestDto requestDto);

    void updateUser(UserUpdateDto updateDto, @MappingTarget User user);

    void updateUserRole(UserRoleUpdateDto roleUpdateDto, @MappingTarget User user);

    @AfterMapping
    default void setRoleIds(UserRoleUpdateDto updateDto, @MappingTarget User user) {
        user.setRoles(updateDto.roleId().stream()
                .map(Role::new)
                .collect(Collectors.toSet()));
    }
}
