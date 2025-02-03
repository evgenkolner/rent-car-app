package app.rent.car.mapper;

import app.rent.car.dto.user.UserRegistrationRequestDto;
import app.rent.car.dto.user.UserRegistrationResponseDto;
import app.rent.car.model.user.User;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        implementationPackage = "<PACKAGE_NAME>.impl")
public interface UserMapper {
    UserRegistrationResponseDto toResponse(User user);

    User toUser(UserRegistrationRequestDto requestDto);
}
