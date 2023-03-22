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
public class SubscriptionResponseDto extends RepresentationModel<SubscriptionResponseDto> {

    @Schema(name = "id", description = "Subscription id", example = "1234")
    Long id;
    @Schema(name = "userId", description = "User id", example = "1234")
    Long userId;
    @DateTimeFormat(iso = ISO.DATE)
    @Schema(name = "startDate", description = "Subscription startDate", example = "2023-02-02")
    LocalDate startDate;


}
