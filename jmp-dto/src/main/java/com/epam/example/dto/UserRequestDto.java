package com.epam.example.dto;

import io.swagger.v3.oas.annotations.Parameter;
import java.time.LocalDate;
import javax.validation.constraints.NotBlank;
import lombok.Builder;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;

@Builder
@Validated
public record UserRequestDto(
    @Parameter(name = "id", description = "User id")
    Long id,
    @Parameter(name = "name", description = "User name")
    @NotBlank
    String name,
    @Parameter(name = "surname", description = "User surname")
    @NotBlank
    String surname,
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Parameter(name = "birthday", description = "User birthday, ISO format")
    LocalDate birthday
) {

}
