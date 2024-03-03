package com.epam.example.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.hateoas.RepresentationModel;

@Value
@Builder
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UserResponseDto extends RepresentationModel<UserResponseDto> {

    @Schema(name = "id", description = "User id", example = "1234")
    Long id;
    @Schema(name = "name", description = "User name", example = "John")
    String name;
    @Schema(name = "surname", description = "User surname", example = "Doe")
    String surname;
    @Schema(name = "birthday", description = "User birthday", example = "2020-02-31")
    @DateTimeFormat(iso = ISO.DATE)
    LocalDate birthday;
}
