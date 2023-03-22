package com.epam.example.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDate;
import javax.validation.constraints.NotBlank;
import lombok.Builder;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;

@Builder
@Validated
public record UserRequestDto(
    @Schema(name = "id", description = "User id", example = "1234")
    Long id,
    @Schema(name = "name", description = "User name", example = "John")
    @NotBlank
    String name,
    @Schema(name = "surname", description = "User surname", example = "Doe")
    @NotBlank
    String surname,
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Schema(name = "birthday", description = "User birthday", example = "2022-12-30")
    LocalDate birthday
) {

}
