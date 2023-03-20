package com.epam.example.dto;

import java.time.LocalDate;
import lombok.Builder;

@Builder
public record Subscription(
    Long id,
    User user,
    LocalDate startDate
) {

}
