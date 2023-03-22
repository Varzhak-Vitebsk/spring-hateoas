package com.epam.example.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import lombok.Builder;

@Builder
public record UsersResponse(
    @Schema(name = "users", description = "List of users")
    List<UserResponseDto> users
) {

}
