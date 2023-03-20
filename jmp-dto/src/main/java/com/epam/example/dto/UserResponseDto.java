package com.epam.example.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDate;
import lombok.Builder;
import org.springframework.format.annotation.DateTimeFormat;

@Builder
public record UserResponseDto(
    @Schema(name = "id", description = "User id", example = "1234")
    Long id,
    @Schema(name = "name", description = "User name", example = "John")
    String name,
    @Schema(name = "surname", description = "User surname", example = "Doe")
    String surname,
    @Schema(name = "birthday", description = "User birthday", example = "")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    LocalDate birthday
) {

}
