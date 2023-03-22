package com.epam.example.dto;

import java.time.LocalDate;
import lombok.Builder;

@Builder
public record User(
    Long id,
    String name,
    String surname,
    LocalDate birthday
) {

}
