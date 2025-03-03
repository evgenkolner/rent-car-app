package app.rent.car.controller;

import app.rent.car.dto.rental.CreateRentalRequestDto;
import app.rent.car.dto.rental.RentalDto;
import app.rent.car.service.rental.RentalService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/rentals")
@RequiredArgsConstructor
@Validated
public class RentalController {
    private final RentalService rentalService;

    @PreAuthorize("hasAuthority('CUSTOMER')")
    @PostMapping
    public RentalDto createRental(@RequestBody @Valid CreateRentalRequestDto requestDto) {
        return rentalService.save(requestDto);
    }

    @PreAuthorize("hasAuthority('MANAGER')")
    @GetMapping
    public List<RentalDto> getAllByUserIdAndIsActive(
            @RequestParam Long userId,
            @RequestParam boolean isActive) {
        return rentalService.getAllByUserIdAndIsActive(userId, isActive);
    }

    @PreAuthorize("hasAuthority('MANAGER')")
    @GetMapping("/{id}")
    public RentalDto getRentalById(@PathVariable Long id) {
        return rentalService.getRentalById(id);
    }

    @PreAuthorize("hasAuthority('MANAGER')")
    @PostMapping("/{id}/return")
    public RentalDto updateReturnTime(@PathVariable Long id) {
        return rentalService.addActualReturnTime(id);
    }
}
