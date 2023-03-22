package com.epam.example.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.NotNull;
import lombok.Builder;
import org.springframework.validation.annotation.Validated;

@Builder
@Validated
public record SubscriptionRequestDto(
    @Schema(name = "id", description = "Subscription id", example = "1234")
    Long id,
    @Schema(name = "userId", description = "User id", example = "1234")
    @NotNull
    Long userId
) {

}
