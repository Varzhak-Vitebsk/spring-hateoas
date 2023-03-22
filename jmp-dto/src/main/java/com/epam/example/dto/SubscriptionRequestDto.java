package com.epam.example.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import javax.validation.constraints.NotNull;
import lombok.Builder;
import org.springframework.validation.annotation.Validated;

@Builder
@Validated
public record SubscriptionRequestDto(
    @Schema(name = "id", description = "Subscription id", example = "1234", requiredMode = RequiredMode.NOT_REQUIRED)
    Long id,
    @Schema(name = "userId", description = "User id", example = "1234", requiredMode = RequiredMode.REQUIRED)
    @NotNull
    Long userId
) {

}
