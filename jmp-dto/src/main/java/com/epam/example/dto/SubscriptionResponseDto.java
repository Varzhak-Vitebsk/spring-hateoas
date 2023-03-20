package com.epam.example.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDate;
import lombok.Builder;
import org.springframework.format.annotation.DateTimeFormat;

@Builder
public record SubscriptionResponseDto(
    @Schema(name = "id", description = "Subscription id", example = "1234")
    Long id,
    @Schema(name = "userId", description = "User id", example = "1234")
    Long userId,
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Schema(name = "startDate", description = "Subscription startDate", example = "")
    LocalDate startDate
) {

}
