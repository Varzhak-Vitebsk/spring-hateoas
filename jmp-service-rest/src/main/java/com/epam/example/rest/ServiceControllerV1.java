package com.epam.example.rest;

import com.epam.example.dto.ErrorResponse;
import com.epam.example.dto.SubscriptionRequestDto;
import com.epam.example.dto.SubscriptionResponseDto;
import com.epam.example.dto.SubscriptionsResponse;
import com.epam.example.dto.UsersResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(path = "/api/public/v1/subscription", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public interface ServiceControllerV1 {

    @Operation(summary = "Create subscription.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", content = {
            @Content(mediaType = "application/json",
                schema = @Schema(implementation = SubscriptionResponseDto.class))
        }),
        @ApiResponse(responseCode = "400", content = {
            @Content(mediaType = "application/json",
                schema = @Schema(implementation = ErrorResponse.class))
        }),
        @ApiResponse(responseCode = "500", content = {
            @Content(mediaType = "application/json",
                schema = @Schema(implementation = ErrorResponse.class))
        })
    })
    @PostMapping
    ResponseEntity<SubscriptionRequestDto> createSubscription(
        @RequestBody @Valid SubscriptionRequestDto request);

    @Operation(summary = "Update subscription.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", content = {
            @Content(mediaType = "application/json",
                schema = @Schema(implementation = SubscriptionResponseDto.class))
        }),
        @ApiResponse(responseCode = "400", content = {
            @Content(mediaType = "application/json",
                schema = @Schema(implementation = ErrorResponse.class))
        }),
        @ApiResponse(responseCode = "404", content = {
            @Content(mediaType = "application/json",
                schema = @Schema(implementation = ErrorResponse.class))
        }),
        @ApiResponse(responseCode = "500", content = {
            @Content(mediaType = "application/json",
                schema = @Schema(implementation = ErrorResponse.class))
        })
    })
    @PatchMapping
    ResponseEntity<SubscriptionResponseDto> updateUser(
        @RequestBody @Valid SubscriptionRequestDto request);

    @Operation(summary = "Delete subscription.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200"),
        @ApiResponse(responseCode = "400", content = {
            @Content(mediaType = "application/json",
                schema = @Schema(implementation = ErrorResponse.class))
        }),
        @ApiResponse(responseCode = "404", content = {
            @Content(mediaType = "application/json",
                schema = @Schema(implementation = ErrorResponse.class))
        }),
        @ApiResponse(responseCode = "500", content = {
            @Content(mediaType = "application/json",
                schema = @Schema(implementation = ErrorResponse.class))
        })
    })
    @DeleteMapping(value = "{id}")
    ResponseEntity<Void> deleteSubscription(
        @PathVariable(name = "id") @NotNull Long id);

    @Operation(summary = "Retrieve subscription.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", content = {
            @Content(mediaType = "application/json",
                schema = @Schema(implementation = SubscriptionResponseDto.class))
        }),
        @ApiResponse(responseCode = "400", content = {
            @Content(mediaType = "application/json",
                schema = @Schema(implementation = ErrorResponse.class))
        }),
        @ApiResponse(responseCode = "404", content = {
            @Content(mediaType = "application/json",
                schema = @Schema(implementation = ErrorResponse.class))
        }),
        @ApiResponse(responseCode = "500", content = {
            @Content(mediaType = "application/json",
                schema = @Schema(implementation = ErrorResponse.class))
        })
    })
    @GetMapping(value = "{id}")
    ResponseEntity<SubscriptionResponseDto> getSubscription(
        @PathVariable(name = "id") @NotNull Long id);

    @Operation(summary = "Retrieve subscriptions.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", content = {
            @Content(mediaType = "application/json",
                schema = @Schema(implementation = UsersResponse.class))
        }),
        @ApiResponse(responseCode = "500", content = {
            @Content(mediaType = "application/json",
                schema = @Schema(implementation = ErrorResponse.class))
        })
    })
    @GetMapping
    ResponseEntity<SubscriptionsResponse> getAllSubscriptions(); //TODO use paging on prod

}
