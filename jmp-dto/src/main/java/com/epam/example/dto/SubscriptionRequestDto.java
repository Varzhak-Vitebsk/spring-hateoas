package com.epam.example.dto;

import io.swagger.v3.oas.annotations.Parameter;
import javax.validation.constraints.NotNull;
import lombok.Builder;
import org.springframework.validation.annotation.Validated;

@Builder
@Validated
public record SubscriptionRequestDto(
    @Parameter(name = "id", description = "Subscription id")
    Long id,
    @Parameter(name = "userId", description = "User id")
    @NotNull
    Long userId
) {

}
