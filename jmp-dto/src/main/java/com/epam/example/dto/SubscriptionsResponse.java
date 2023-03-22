package com.epam.example.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import lombok.Builder;

@Builder
public record SubscriptionsResponse(
    @Schema(name = "subscriptions", description = "List of subscriptions")
    List<SubscriptionResponseDto> subscriptions
) {

}
